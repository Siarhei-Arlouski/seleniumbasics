package pageobject.objectbased.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



}
