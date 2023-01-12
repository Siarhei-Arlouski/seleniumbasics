package pageobject.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.pagefactory.pages.HomePagePF;
import pageobject.pagefactory.pages.SubcategoryPagePF;
import java.util.ArrayList;
import java.util.List;

public class TestClassPF extends TestBasePF{
    @Test
    public void homePageTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.homePageButtonClick();

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
    }

    @Test
    public void rubberDucksPageTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.rubberDucksPageButtonClick();

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
    }

    @Test
    public void deliveryInformationPageTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.deliveryInformationPageLinkClick();

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
    }

    @Test
    public void termsAndConditionsTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.termsAndConditionsLinkClick();

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");
    }

    @Test
    public void sortByNameTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.subcategoryButtonClick(driver);

        SubcategoryPagePF subcategoryPagePF = PageFactory.initElements(driver, SubcategoryPagePF.class);
        subcategoryPagePF.nameButtonClick();

        ArrayList<String> expectedSortListByName = new ArrayList<>();
        expectedSortListByName.add("Green Duck");
        expectedSortListByName.add("Yellow Duck");

        List<WebElement> actualSortListByName = driver.findElements(By.className("name"));

        Assert.assertEquals(actualSortListByName.get(0).getText(), expectedSortListByName.get(0));
        Assert.assertEquals(actualSortListByName.get(1).getText(), expectedSortListByName.get(1));
    }

    @Test
    public void sortByPriceTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.subcategoryButtonClick(driver);

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
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.subcategoryButtonClick(driver);

        SubcategoryPagePF subcategoryPagePF = PageFactory.initElements(driver, SubcategoryPagePF.class);

        Assert.assertEquals(subcategoryPagePF.greenDuckLabelText(), "NEW");
    }

    @Test
    public void yellowDuckLabelTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        homePagePF.subcategoryButtonClick(driver);

        SubcategoryPagePF subcategoryPagePF = PageFactory.initElements(driver, SubcategoryPagePF.class);

        Assert.assertEquals(subcategoryPagePF.yellowDuckLabelText(), "SALE");
    }

    @Test
    public void openLiteCartSiteTest() {
        HomePagePF homePagePF = PageFactory.initElements(driver, HomePagePF.class);

        String initialTab = driver.getWindowHandle();
        homePagePF.liteCartLinkClick();
        String liteCartSiteTab = driver.getWindowHandles().toArray()[1].toString();

        driver.switchTo().window(liteCartSiteTab);
        Assert.assertEquals(driver.getTitle(), "LiteCart - Free shopping cart platform");

        driver.close();
        driver.switchTo().window(initialTab);
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
    }
}
