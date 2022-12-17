import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

    @Test
    void homePage() {
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homePageLink = driver.findElement(By.xpath("//i[@title='Home']"));
        homePageLink.click();

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
    }

    @Test
    void rubberDucksPage() {
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksPageLink = driver.findElement(By.xpath("//nav[@id='site-menu']//a[text()='Rubber Ducks']"));
        rubberDucksPageLink.click();

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
    }

    @Test
    void deliveryInformationPage() {
        driver.get("https://litecart.stqa.ru/en/");
        WebElement deliveryInformationPageLink = driver.findElement(By.xpath("//*[text()='Delivery Information']"));
        deliveryInformationPageLink.click();

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
    }

    @Test
    void termsAndConditions() {
        driver.get("https://litecart.stqa.ru/en/");
        WebElement termsAndConditionsLink = driver.findElement(By.xpath("//*[text()='Terms & Conditions']"));
        termsAndConditionsLink.click();

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");

    }

}
