package pageobject.objectbased;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver driver;
    String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
