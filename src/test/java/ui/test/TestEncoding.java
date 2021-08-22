package ui.test;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;
import ui.page.BasePage;
import ui.page.StartPage;
import ui.page.StatusExtendedPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static ui.testconfig.Config.URL_RESPONSE;

public class TestEncoding extends BasePage {
    StartPage startPage = new StartPage();
    StatusExtendedPage extendedPage = new StatusExtendedPage();

    @Test
    public void searchEncoding() {
       startPage.searchElement();
       startPage.textOnFieldSearch("getStatus");
       startPage.setValueStatus();
       extendedPage.clickButtonJson();
       assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), URL_RESPONSE);
       assertThat(extendedPage.elementJson(),hasItems(
                containsString("\"processor\": \"[AMAZON | RACKSPACE]\"")
               ,containsString("\"status\": \"[Status]\"")));
    }
}
