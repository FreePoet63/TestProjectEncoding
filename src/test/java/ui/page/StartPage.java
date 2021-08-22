package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StartPage {
    SelenideElement searchSet = $x("//div[text()=\"Search\"]");
    SelenideElement setTextSearchField = $x("//input[contains(@class,\"Input\")]");
    SelenideElement setStatus = $x("//a[@href=\"/reference-link/responses-getstatus-extended\"]");

    public void searchElement() {
        $(searchSet).click();
    }

    public void textOnFieldSearch(String value) {
        $(setTextSearchField).setValue(value);
    }

    public void setValueStatus() {
        $(setStatus).shouldBe(Condition.enabled, Duration.ofSeconds(7)).click();
    }
}
