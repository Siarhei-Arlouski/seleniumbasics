import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainTest {

    WebDriver driver = new ChromeDriver();

    @Test
    void firstLink() {
        driver.get("https://the-internet.herokuapp.com/");
    }

}
