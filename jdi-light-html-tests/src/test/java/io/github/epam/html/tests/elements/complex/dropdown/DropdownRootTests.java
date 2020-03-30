package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.TextTypes.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.LogSidebar.*;
import static io.github.com.pages.MetalAndColorsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.elements.complex.enums.Colors.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownRootTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colorsRoot.select(text);
    }
    String text = "Colors";

    @Test
    public void getValueTest() {
        assertEquals(colorsRoot.getValue(), text);
    }
    @Test
    public void selectStringTest() {
        colorsRoot.select("Red");
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colorsRoot.select(Green);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Green"));
    }

    @Test
    public void selectIndexTest() {
        colorsRoot.select(4);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colorsRoot.select(Yellow);
        assertThat(colorsRoot.getValue(), is("Yellow"));
        assertThat(colorsRoot.selected(), is("Yellow"));
        assertThat(colorsRoot.getText(), is("Yellow"));
    }

    @Test
    public void negativeDropdownTest() {
        try {
            colorsRoot.base().waitSec(1);
            colorsRoot.select("GreyBrownCrimson");
            fail("You have selected color that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't find Element 'Colors Root list[GreyBrownCrimson]"));
        }
    }

    @Test
    public void isValidationTest() {
        colorsRoot.is().selected("Colors");
        colorsRoot.is().values(INNER, hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colorsRoot.assertThat().values(INNER, contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colorsRoot.values(INNER), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void expandTests() {
        assertThat(colorsRoot.listEnabled(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
        assertThat(colorsRoot.listDisabled(), empty());
        assertThat(colorsRoot.values(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(colors5.value());
    }
}

