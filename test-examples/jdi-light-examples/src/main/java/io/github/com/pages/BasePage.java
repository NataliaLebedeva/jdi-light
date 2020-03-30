package io.github.com.pages;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.hasRunDrivers;

public class BasePage extends WebPage {
    @Css("h3[name='test']") public WebElement testField;

    @Override
    @JDIAction("Check that '{name}' is opened (url {checkUrlType} '{checkUrl}'; title {checkTitleType} '{title}')")
    public void checkOpened(){
        if (!hasRunDrivers())
            throw exception("Page '%s' is not opened: Driver is not run", toString());
    }
}
