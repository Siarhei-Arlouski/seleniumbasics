package pageobject.objectbased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.objectbased.pages.HomePage;
import pageobject.objectbased.pages.SubcategoryPage;
import java.util.ArrayList;
import java.util.List;

public class TestClass extends TestBase{
    @Test
    public void homePageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.homePageButtonClick();

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
    }

    @Test
    public void rubberDucksPageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.rubberDucksPageButtonClick();

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
    }

    @Test
    public void deliveryInformationPageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.deliveryInformationPageLinkClick();

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
    }

    @Test
    public void termsAndConditionsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.termsAndConditionsLinkClick();

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");
    }

    @Test
    public void sortByNameTest() {
        HomePage homePage = new HomePage(driver);
        homePage.subcategoryButtonClick();

        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.nameButtonClick();

        ArrayList<String> expectedSortListByName = new ArrayList<>();
        expectedSortListByName.add("Green Duck");
        expectedSortListByName.add("Yellow Duck");

        List<WebElement> actualSortListByName = driver.findElements(By.className("name"));

        Assert.assertEquals(actualSortListByName.get(0).getText(), expectedSortListByName.get(0));
        Assert.assertEquals(actualSortListByName.get(1).getText(), expectedSortListByName.get(1));
    }

    @Test
    public void sortByPriceTest() {
        HomePage homePage = new HomePage(driver);
        homePage.subcategoryButtonClick();

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
        HomePage homePage = new HomePage(driver);
        homePage.subcategoryButtonClick();

        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);

        Assert.assertEquals(subcategoryPage.greenDuckLabelText(), "NEW");
    }

    @Test
    public void yellowDuckLabelTest() {
        HomePage homePage = new HomePage(driver);
        homePage.subcategoryButtonClick();

        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);

        Assert.assertEquals(subcategoryPage.yellowDuckLabelText(), "SALE");
    }

    @Test
    public void openLiteCartSiteTest() {
        HomePage homePage = new HomePage(driver);

        String initialTab = driver.getWindowHandle();
        homePage.liteCartLinkClick();
        String liteCartSiteTab = driver.getWindowHandles().toArray()[1].toString();

        driver.switchTo().window(liteCartSiteTab);
        Assert.assertEquals(driver.getTitle(), "LiteCart - Free shopping cart platform");

        driver.close();
        driver.switchTo().window(initialTab);
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
    }
}
