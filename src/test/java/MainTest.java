import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest {

    @Test
    void objLinks() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> objLinks = driver.findElements(By.tagName("a"));
        objLinks.get(10).click();
    }

    @Test
    void homePage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homePageLink = driver.findElement(By.xpath("//i[@title='Home']"));
        homePageLink.click();

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
    }

    @Test
    void rubberDucksPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksPageLink = driver.findElement(By.xpath("//nav[@id='site-menu']//a[text()='Rubber Ducks']"));
        rubberDucksPageLink.click();

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
    }

    @Test
    void deliveryInformationPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement deliveryInformationPageLink = driver.findElement(By.xpath("//*[text()='Delivery Information']"));
        deliveryInformationPageLink.click();

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
    }

    @Test
    void termsAndConditions() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement termsAndConditionsLink = driver.findElement(By.xpath("//*[text()='Terms & Conditions']"));
        termsAndConditionsLink.click();

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");

    }

    @Test
    void iconDoubleClick() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.pbclibrary.org/mousing/click3.htm");

        WebElement IEIcon = driver.findElement(By.name("icon1"));
        WebElement WordIcon = driver.findElement(By.name("icon2"));
        WebElement PPIcon = driver.findElement(By.name("icon3"));

        Actions builder = new Actions(driver);

        builder.doubleClick(IEIcon).doubleClick(WordIcon).doubleClick(PPIcon).perform();
    }

    @Test
    void ballDragAndDrop() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement gate = driver.findElement(By.id("gate"));

        Actions builder = new Actions(driver);

        builder.dragAndDrop(ball, gate).perform();
    }

    @Test
    void alerts() {
        
    }

}
