package pageobject.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePagePF {
    @FindBy(xpath = "//i[@title='Home']")
    private WebElement homePageButton;

    @FindBy(xpath = "//nav[@id='site-menu']//a[text()='Rubber Ducks']")
    private WebElement rubberDucksPageButton;

    @FindBy(xpath = "//*[@class='category-2']/a")
    private WebElement subcategoryButton;

    @FindBy(xpath = "//*[text()='Delivery Information']")
    private WebElement deliveryInformationPageLink;

    @FindBy(xpath = "//*[text()='Terms & Conditions']")
    private WebElement termsAndConditionsLink;

    @FindBy(xpath = "//*[@title='Free e-commerce platform']")
    private WebElement liteCartLink;

    public void homePageButtonClick() {
        homePageButton.click();
    }

    public void rubberDucksPageButtonClick() {
        rubberDucksPageButton.click();
    }

    public void subcategoryButtonClick(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksPageButton)
                .click(subcategoryButton)
                .perform();
    }

    public void deliveryInformationPageLinkClick() {
        deliveryInformationPageLink.click();
    }

    public void termsAndConditionsLinkClick() {
        termsAndConditionsLink.click();
    }

    public void liteCartLinkClick() {
        liteCartLink.click();
    }
}
