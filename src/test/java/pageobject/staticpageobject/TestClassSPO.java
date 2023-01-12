package pageobject.staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.staticpageobject.pages.HomePageSPO;
import pageobject.staticpageobject.pages.SubcategoryPageSPO;
import java.util.ArrayList;
import java.util.List;

public class TestClassSPO extends TestBaseSPO{
    @Test
    public void homePageTest() {
        HomePageSPO.homePageButtonClick(driver);

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
    }

    @Test
    public void rubberDucksPageTest() {
        HomePageSPO.rubberDucksPageButtonClick(driver);

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
    }

    @Test
    public void deliveryInformationPageTest() {
        HomePageSPO.deliveryInformationPageLinkClick(driver);

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
    }

    @Test
    public void termsAndConditionsTest() {
        HomePageSPO.termsAndConditionsLinkClick(driver);

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");
    }

    @Test
    public void sortByNameTest() {
        HomePageSPO.subcategoryButtonClick(driver);

        SubcategoryPageSPO.nameButtonClick(driver);

        ArrayList<String> expectedSortListByName = new ArrayList<>();
        expectedSortListByName.add("Green Duck");
        expectedSortListByName.add("Yellow Duck");

        List<WebElement> actualSortListByName = driver.findElements(By.className("name"));

        Assert.assertEquals(actualSortListByName.get(0).getText(), expectedSortListByName.get(0));
        Assert.assertEquals(actualSortListByName.get(1).getText(), expectedSortListByName.get(1));
    }

    @Test
    public void sortByPriceTest() {
        HomePageSPO.subcategoryButtonClick(driver);

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
        HomePageSPO.subcategoryButtonClick(driver);

        Assert.assertEquals(SubcategoryPageSPO.greenDuckLabelText(driver), "NEW");
    }

    @Test
    public void yellowDuckLabelTest() {
        HomePageSPO.subcategoryButtonClick(driver);

        Assert.assertEquals(SubcategoryPageSPO.yellowDuckLabelText(driver), "SALE");
    }

    @Test
    public void openLiteCartSiteTest() {
        String initialTab = driver.getWindowHandle();
        HomePageSPO.liteCartLinkClick(driver);
        String liteCartSiteTab = driver.getWindowHandles().toArray()[1].toString();

        driver.switchTo().window(liteCartSiteTab);
        Assert.assertEquals(driver.getTitle(), "LiteCart - Free shopping cart platform");

        driver.close();
        driver.switchTo().window(initialTab);
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
    }
}
