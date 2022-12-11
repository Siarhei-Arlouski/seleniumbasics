import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest {

    WebDriver driver = new ChromeDriver();

    @Test
    void objLinks() {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> objLinks = driver.findElements(By.tagName("a"));
        objLinks.get(10).click();
    }

}
