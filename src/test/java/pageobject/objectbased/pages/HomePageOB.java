package pageobject.objectbased.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePageOB {
    private final By homePageButton = By.xpath("//i[@title='Home']");
    private final By rubberDucksPageButton = By.xpath("//nav[@id='site-menu']//a[text()='Rubber Ducks']");
    private final By subcategoryButton = By.xpath("//*[@class='category-2']/a");
    private final By deliveryInformationPageLink = By.xpath("//*[text()='Delivery Information']");
    private final By termsAndConditionsLink = By.xpath("//*[text()='Terms & Conditions']");
    private final By liteCartLink = By.xpath("//*[@title='Free e-commerce platform']");

    private final WebDriver driver;

    public HomePageOB(WebDriver driver) {
        this.driver = driver;
    }

    public void homePageButtonClick() {
        driver.findElement(homePageButton).click();
    }

    public void rubberDucksPageButtonClick() {
        driver.findElement(rubberDucksPageButton).click();
    }

    public void subcategoryButtonClick() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(rubberDucksPageButton))
                .click(driver.findElement(subcategoryButton))
                .perform();
    }

    public void deliveryInformationPageLinkClick() {
        driver.findElement(deliveryInformationPageLink).click();
    }

    public void termsAndConditionsLinkClick() {
        driver.findElement(termsAndConditionsLink).click();
    }

    public void liteCartLinkClick() {
        driver.findElement(liteCartLink).click();
    }
}
