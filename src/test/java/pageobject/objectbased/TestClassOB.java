package pageobject.objectbased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.objectbased.pages.HomePageOB;
import pageobject.objectbased.pages.SubcategoryPageOB;
import java.util.ArrayList;
import java.util.List;

public class TestClassOB extends TestBaseOB {
    @Test
    public void homePageTest() {
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.homePageButtonClick();

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
    }

    @Test
    public void rubberDucksPageTest() {
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.rubberDucksPageButtonClick();

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
    }

    @Test
    public void deliveryInformationPageTest() {
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.deliveryInformationPageLinkClick();

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
    }

    @Test
    public void termsAndConditionsTest() {
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.termsAndConditionsLinkClick();

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");
    }

    @Test
    public void sortByNameTest() {
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.subcategoryButtonClick();

        SubcategoryPageOB subcategoryPageOB = new SubcategoryPageOB(driver);
        subcategoryPageOB.nameButtonClick();

        ArrayList<String> expectedSortListByName = new ArrayList<>();
        expectedSortListByName.add("Green Duck");
        expectedSortListByName.add("Yellow Duck");

        List<WebElement> actualSortListByName = driver.findElements(By.className("name"));

        Assert.assertEquals(actualSortListByName.get(0).getText(), expectedSortListByName.get(0));
        Assert.assertEquals(actualSortListByName.get(1).getText(), expectedSortListByName.get(1));
    }

    @Test
    public void sortByPriceTest() {
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.subcategoryButtonClick();

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
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.subcategoryButtonClick();

        SubcategoryPageOB subcategoryPageOB = new SubcategoryPageOB(driver);

        Assert.assertEquals(subcategoryPageOB.greenDuckLabelText(), "NEW");
    }

    @Test
    public void yellowDuckLabelTest() {
        HomePageOB homePageOB = new HomePageOB(driver);
        homePageOB.subcategoryButtonClick();

        SubcategoryPageOB subcategoryPageOB = new SubcategoryPageOB(driver);

        Assert.assertEquals(subcategoryPageOB.yellowDuckLabelText(), "SALE");
    }

    @Test
    public void openLiteCartSiteTest() {
        HomePageOB homePageOB = new HomePageOB(driver);

        String initialTab = driver.getWindowHandle();
        homePageOB.liteCartLinkClick();
        String liteCartSiteTab = driver.getWindowHandles().toArray()[1].toString();

        driver.switchTo().window(liteCartSiteTab);
        Assert.assertEquals(driver.getTitle(), "LiteCart - Free shopping cart platform");

        driver.close();
        driver.switchTo().window(initialTab);
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
    }
}
