package pageobject.objectbased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class TestClass extends TestBase{
    @Test
    public void homePageTest() {
        WebElement homePageLink = driver.findElement(By.xpath("//i[@title='Home']"));
        homePageLink.click();

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
    }

    @Test
    public void rubberDucksPageTest() {
        WebElement rubberDucksPageLink = driver.findElement(By.xpath("//nav[@id='site-menu']//a[text()='Rubber Ducks']"));
        rubberDucksPageLink.click();

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
    }

    @Test
    public void deliveryInformationPageTest() {
        WebElement deliveryInformationPageLink = driver.findElement(By.xpath("//*[text()='Delivery Information']"));
        deliveryInformationPageLink.click();

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
    }

    @Test
    public void termsAndConditionsTest() {
        WebElement termsAndConditionsLink = driver.findElement(By.xpath("//*[text()='Terms & Conditions']"));
        termsAndConditionsLink.click();

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");
    }

    @Test
    public void sortByNameTest() {
        WebElement rubberDucksMenuButton = driver.findElement(By.cssSelector("#site-menu .category-1"));
        WebElement subcategoryMenuButton = driver.findElement(By.cssSelector("#site-menu .category-2 a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksMenuButton)
                .click(subcategoryMenuButton)
                .perform();

        WebElement nameButton = driver.findElement(By.xpath("//*[@class='button'][text()='Name']"));

        builder.click(nameButton).perform();

        ArrayList<String> expectedSortListByName = new ArrayList<>();
        expectedSortListByName.add("Green Duck");
        expectedSortListByName.add("Yellow Duck");

        List<WebElement> actualSortListByName = driver.findElements(By.className("name"));

        Assert.assertEquals(actualSortListByName.get(0).getText(), expectedSortListByName.get(0));
        Assert.assertEquals(actualSortListByName.get(1).getText(), expectedSortListByName.get(1));
    }

    @Test
    public void sortByPriceTest() {
        WebElement rubberDucksMenuButton = driver.findElement(By.cssSelector("#site-menu .category-1"));
        WebElement subcategoryMenuButton = driver.findElement(By.cssSelector("#site-menu .category-2 a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksMenuButton)
                .click(subcategoryMenuButton)
                .perform();

        ArrayList<String> expectedSortListByPrice = new ArrayList<>();
        expectedSortListByPrice.add("$18");
        expectedSortListByPrice.add("$20");

        List<WebElement> actualSortListByPrice = driver.findElements(By.className("campaign-price"));
        actualSortListByPrice.add(driver.findElement(By.className("price")));

        Assert.assertEquals(actualSortListByPrice.get(0).getText(), expectedSortListByPrice.get(0));
        Assert.assertEquals(actualSortListByPrice.get(1).getText(), expectedSortListByPrice.get(1));
    }

    @Test
    public void greenDuckLabelTest() {
        WebElement rubberDucksMenuButton = driver.findElement(By.cssSelector("#site-menu .category-1"));
        WebElement subcategoryMenuButton = driver.findElement(By.cssSelector("#site-menu .category-2 a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksMenuButton)
                .click(subcategoryMenuButton)
                .perform();

        WebElement greenDuckLabel = driver.findElement(By.xpath("//*[@title='Green Duck']/*/*[@class='sticker new']"));

        Assert.assertEquals(greenDuckLabel.getText(), "NEW");
    }

    @Test
    public void yellowDuckLabelTest() {
        WebElement rubberDucksMenuButton = driver.findElement(By.cssSelector("#site-menu .category-1"));
        WebElement subcategoryMenuButton = driver.findElement(By.cssSelector("#site-menu .category-2 a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksMenuButton)
                .click(subcategoryMenuButton)
                .perform();

        WebElement greenDuckLabel = driver.findElement(By.xpath("//*[@title='Yellow Duck']/*/*[@class='sticker sale']"));

        Assert.assertEquals(greenDuckLabel.getText(), "SALE");
    }

    @Test
    public void openLiteCartSiteTest() {
        WebElement liteCartSiteButton = driver.findElement(By.cssSelector("[title='Free e-commerce platform']"));

        String initialTab = driver.getWindowHandle();
        liteCartSiteButton.click();
        String liteCartSiteTab = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(liteCartSiteTab);

        String liteCartSiteTitle = driver.getTitle();
        Assert.assertEquals(liteCartSiteTitle, "LiteCart - Free shopping cart platform");

        driver.close();
        driver.switchTo().window(initialTab);

        String initTabTitle = driver.getTitle();
        Assert.assertEquals(initTabTitle, "Online Store | My Store");
    }
}
