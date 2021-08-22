package ui.page;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    @BeforeClass
    public void setUp() {
        Configuration.browser = Browsers.FIREFOX;
        Configuration.startMaximized = true;
        open("https://api.encoding.com/");
    }
}
