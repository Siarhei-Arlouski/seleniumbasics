package pageobject.objectbased.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubcategoryPage {
    private final By nameButton = By.xpath("//*[@class='button'][text()='Name']");
    private final By greenDuckLabelText = By.xpath("//*[@title='Green Duck']/*/*[@class='sticker new']");
    private final By yellowDuckLabelText = By.xpath("//*[@title='Yellow Duck']/*/*[@class='sticker sale']");

    private final WebDriver driver;

    public SubcategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void nameButtonClick() {
        driver.findElement(nameButton).click();
    }

    public String greenDuckLabelText() {
        return driver.findElement(greenDuckLabelText).getText();
    }

    public String yellowDuckLabelText() {
        return driver.findElement(yellowDuckLabelText).getText();
    }
}
