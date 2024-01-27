package lesson10.config;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;

public class Browser {
    public static void setBrowser(){
        SelenideConfig selenideConfig = new SelenideConfig();
        selenideConfig.browser("firefox");
        selenideConfig.pageLoadStrategy("normal");
        selenideConfig.timeout(10000);
        selenideConfig.pageLoadTimeout(32000);


        SelenideDriver selenideDriver = new SelenideDriver(selenideConfig);
        WebDriverRunner.setWebDriver(selenideDriver.getAndCheckWebDriver());
    }
}
