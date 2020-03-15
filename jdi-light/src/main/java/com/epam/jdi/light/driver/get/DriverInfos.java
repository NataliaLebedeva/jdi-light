package com.epam.jdi.light.driver.get;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.opera.*;
import org.openqa.selenium.safari.*;

import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfos {
    public static DriverInfo CHROME_INFO = new DriverInfo()
        .set(d -> {
            d.type = CHROME;
            d.initCapabilities = new ChromeOptions();
            d.capabilities = c -> getCapabilities(c, cap -> CHROME_OPTIONS.execute((ChromeOptions) cap));
            d.properties = "webdriver.chrome.driver";
            d.path = chromeDriverPath();
            d.getDriver = c -> new ChromeDriver((ChromeOptions) c);
        }
    );
    public static DriverInfo FF_INFO = new DriverInfo()
        .set(d -> {
            d.type = FIREFOX;
            d.initCapabilities = new FirefoxOptions();
            d.capabilities = c -> getCapabilities(c, cap -> FIREFOX_OPTIONS.execute((FirefoxOptions) cap));
            d.properties = "webdriver.gecko.driver";
            d.path = firefoxDriverPath();
            d.getDriver = c -> new FirefoxDriver((FirefoxOptions) c);
        }
    );
    public static DriverInfo IE_INFO = new DriverInfo()
        .set(d -> {
            d.type = IE;
            d.initCapabilities = new InternetExplorerOptions();
            d.capabilities = c -> getCapabilities(c, cap -> IE_OPTIONS.execute((InternetExplorerOptions) cap));
            d.properties = "webdriver.ie.driver";
            d.path = ieDriverPath();
            d.getDriver = c -> new InternetExplorerDriver((InternetExplorerOptions) c);
        }
    );
    public static DriverInfo OPERA_INFO = new DriverInfo()
        .set(d -> {
            d.type = OPERA;
            d.initCapabilities = new OperaOptions();
            d.capabilities = c -> getCapabilities(c, cap -> OPERA_OPTIONS.execute((OperaOptions) cap));
            d.properties = "webdriver.opera.driver";
            d.path = operaDriverPath();
            d.getDriver = c -> new OperaDriver((OperaOptions) c);
        }
    );
    public static DriverInfo EDGE_INFO = new DriverInfo()
        .set(d -> {
            d.type = EDGE;
            d.initCapabilities = new EdgeOptions();
            d.capabilities = c -> getCapabilities(c, cap -> EDGE_OPTIONS.execute((EdgeOptions) cap));
            d.properties = "webdriver.edge.driver";
            d.path = edgeDriverPath();
            d.getDriver = c -> new EdgeDriver((EdgeOptions) c);
        }
    );
    public static DriverInfo SAFARI_INFO = new DriverInfo()
        .set(d -> {
            d.type = SAFARI;
            d.initCapabilities = new SafariOptions();
            d.capabilities = c -> getCapabilities(c, cap -> SAFARI_OPTIONS.execute((SafariOptions) cap));
            d.properties = "webdriver.safari.driver";
            d.path = safariDriverPath();
            d.getDriver = c -> new SafariDriver((SafariOptions) c);
        }
    );
}
