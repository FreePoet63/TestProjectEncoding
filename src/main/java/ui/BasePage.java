package ui;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    @BeforeTest
    public static void setUp() {
        Configuration.browser = Browsers.FIREFOX;
        Configuration.startMaximized = true;
        open("https://api.encoding.com/");
    }
}
