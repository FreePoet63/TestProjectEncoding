package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class StatusExtendedPage {
    SelenideElement buttonJson = $x("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[2]");
    ElementsCollection collection = $$x("//pre[@class=\"CodeTabs_active\"]");

    public void clickButtonJson() {
        $(buttonJson).shouldBe(Condition.enabled, Duration.ofSeconds(7)).click();
    }

    public ElementsCollection jsonList() {
        return $$(collection);
    }

    public List<String> elementJson() {
        ElementsCollection listJsonCollection = jsonList();
        List<String> listJsonResponse = listJsonCollection
                .stream()
                .map(ele -> ele.getText())
                .collect(Collectors.toList());
        return listJsonResponse;
    }
}
