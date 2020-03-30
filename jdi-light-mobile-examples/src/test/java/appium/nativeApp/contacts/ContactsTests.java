package appium.nativeApp.contacts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static appium.nativeApp.contacts.StaticApp.mainPage;
import static appium.nativeApp.contacts.StaticApp.newContactPage;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ContactsTests {

    //private static ContactsMainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        initElements(StaticApp.class);
        //mainPage = new ContactsMainPage();
        logger.toLog("Run Tests");
    }

    @Test
    public void selectPhoneTypeTest(){
        mainPage.createNewContact();
        newContactPage.checkOpened();
        newContactPage.fillInNewContactInformation();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}