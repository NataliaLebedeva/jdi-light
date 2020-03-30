package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.elements.common.Keyboard;
import com.epam.jdi.light.elements.common.Mouse;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.elements.common.Alerts.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 12.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class ButtonTests implements TestsInit {
    final String text = "Red button";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        redButton.show();
        Mouse.mouseClick(redButton);
        Timer.sleep(10000);
    }

    @Test
    public void getTextTest() {
        assertEquals(redButton.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(redButton.getValue(), text);
    }

    @Test
    public void clickTest() {
        redButton.click();
        validateAlert(is("Red button"));
    }

    @Test
    public void disableButtonTest() {
        try {
            disabledButton.click();
            fail("Disabled button should not work, but work");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                containsString("Can't perform click. Element is disabled"));
        }
    }

    @Test
    public void doubleClickTest() {
        doubleButton.doubleClick();
        validateAlert(is("Double Click"));
    }

    @Test
    public void rightClickTest() {
        redButton.rightClick();
        validateAlert("Right Click");
        Keyboard.keyPress("Escape");
    }

    @Test
    public void isValidationTest() {
        redButton.is().displayed();
        redButton.is().enabled();
        redButton.is().text(is(text));
        redButton.is().text(containsString("Red"));
        assertThat(redButton.core().css("font-size"), is("16px"));
        redButton.assertThat().displayed()
            .and().text(is(text))
            .core()
            .css("font-size", is("16px"))
            .cssClass("btn btn-danger")
            .attr("type", "button")
            .tag(is("button"));
        disabledButton.is().text(containsString("Disabled button"));
        // disabledButtonInput.is().text(containsString("Disabled Button"));
        disabledButton.is().disabled();
    }

    @Test
    public void assertValidationTest() {
        redButton.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(redButton);
    }
}
