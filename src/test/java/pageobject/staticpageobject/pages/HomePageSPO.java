package pageobject.staticpageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePageSPO {
    private static final By homePageButton = By.xpath("//i[@title='Home']");
    private static final By rubberDucksPageButton = By.xpath("//nav[@id='site-menu']//a[text()='Rubber Ducks']");
    private static final By subcategoryButton = By.xpath("//*[@class='category-2']/a");
    private static final By deliveryInformationPageLink = By.xpath("//*[text()='Delivery Information']");
    private static final By termsAndConditionsLink = By.xpath("//*[text()='Terms & Conditions']");
    private static final By liteCartLink = By.xpath("//*[@title='Free e-commerce platform']");

    public static void homePageButtonClick(WebDriver driver) {
        driver.findElement(homePageButton).click();
    }

    public static void rubberDucksPageButtonClick(WebDriver driver) {
        driver.findElement(rubberDucksPageButton).click();
    }

    public static void subcategoryButtonClick(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(rubberDucksPageButton))
                .click(driver.findElement(subcategoryButton))
                .perform();
    }

    public static void deliveryInformationPageLinkClick(WebDriver driver) {
        driver.findElement(deliveryInformationPageLink).click();
    }

    public static void termsAndConditionsLinkClick(WebDriver driver) {
        driver.findElement(termsAndConditionsLink).click();
    }

    public static void liteCartLinkClick(WebDriver driver) {
        driver.findElement(liteCartLink).click();
    }
}
