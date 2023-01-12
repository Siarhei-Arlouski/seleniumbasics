package pageobject.staticpageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubcategoryPageSPO {
    private static final By nameButton = By.xpath("//*[@class='button'][text()='Name']");
    private static final By greenDuckLabelText = By.xpath("//*[@title='Green Duck']/*/*[@class='sticker new']");
    private static final By yellowDuckLabelText = By.xpath("//*[@title='Yellow Duck']/*/*[@class='sticker sale']");

    public static void nameButtonClick(WebDriver driver) {
        driver.findElement(nameButton).click();
    }

    public static String greenDuckLabelText(WebDriver driver) {
        return driver.findElement(greenDuckLabelText).getText();
    }

    public static String yellowDuckLabelText(WebDriver driver) {
        return driver.findElement(yellowDuckLabelText).getText();
    }
}
