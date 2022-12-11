import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {

    WebDriver driver = new ChromeDriver();

    void firstLink() {
        driver.get("https://the-internet.herokuapp.com/");
    }

}
