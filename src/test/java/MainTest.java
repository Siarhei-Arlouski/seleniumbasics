import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    void objLinksTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> objLinks = driver.findElements(By.tagName("a"));
        objLinks.get(10).click();
        driver.quit();
    }

    @Test
    void homePageTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homePageLink = driver.findElement(By.xpath("//i[@title='Home']"));
        homePageLink.click();

        String titleHomePage = driver.getTitle();

        Assert.assertEquals(titleHomePage, "Online Store | My Store");
        driver.quit();
    }

    @Test
    void rubberDucksPageTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksPageLink = driver.findElement(By.xpath("//nav[@id='site-menu']//a[text()='Rubber Ducks']"));
        rubberDucksPageLink.click();

        String titleRDPage = driver.getTitle();

        Assert.assertEquals(titleRDPage, "Rubber Ducks | My Store");
        driver.quit();
    }

    @Test
    void deliveryInformationPageTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement deliveryInformationPageLink = driver.findElement(By.xpath("//*[text()='Delivery Information']"));
        deliveryInformationPageLink.click();

        String titleDIPage = driver.getTitle();

        Assert.assertEquals(titleDIPage, "Delivery Information | My Store");
        driver.quit();
    }

    @Test
    void termsAndConditionsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement termsAndConditionsLink = driver.findElement(By.xpath("//*[text()='Terms & Conditions']"));
        termsAndConditionsLink.click();

        String titleTACPage = driver.getTitle();

        Assert.assertEquals(titleTACPage, "Terms & Conditions | My Store");
        driver.quit();
    }

    @Test
    void iconDoubleClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.pbclibrary.org/mousing/click3.htm");

        WebElement IEIcon = driver.findElement(By.name("icon1"));
        WebElement WordIcon = driver.findElement(By.name("icon2"));
        WebElement PPIcon = driver.findElement(By.name("icon3"));

        Actions builder = new Actions(driver);

        builder.doubleClick(IEIcon).doubleClick(WordIcon).doubleClick(PPIcon).perform();
        driver.quit();
    }

    @Test
    void ballDragAndDropTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement gate = driver.findElement(By.id("gate"));

        Actions builder = new Actions(driver);

        builder.dragAndDrop(ball, gate).perform();
        driver.quit();
    }

    @Test
    void alertJSTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSAlert = driver.findElement(By.cssSelector("[onclick='jsAlert()']"));
        JSAlert.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        alert.accept();

        WebElement result = driver.findElement(By.xpath("//*[@id='result']"));
        String resultText = result.getText();
        Assert.assertEquals(resultText, "You successfully clicked an alert");
        driver.quit();
    }

    @Test
    void confirmJSTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSAlert = driver.findElement(By.cssSelector("[onclick='jsConfirm()']"));
        JSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement result = driver.findElement(By.xpath("//*[@id='result']"));
        String resultText = result.getText();
        Assert.assertEquals(resultText, "You clicked: Cancel");
        driver.quit();
    }

    @Test
    void promptJSTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSAlert = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));
        JSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        alert.accept();

        WebElement result = driver.findElement(By.xpath("//*[@id='result']"));
        String resultText = result.getText();
        Assert.assertEquals(resultText, "You entered: Hello World!");
        driver.quit();
    }

    @Test
    void sortByNameTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

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
        driver.quit();
    }

    @Test
    void sortByPriceTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

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

        driver.quit();
    }

    @Test
    void greenDuckLabelTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksMenuButton = driver.findElement(By.cssSelector("#site-menu .category-1"));
        WebElement subcategoryMenuButton = driver.findElement(By.cssSelector("#site-menu .category-2 a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksMenuButton)
                .click(subcategoryMenuButton)
                .perform();

        WebElement greenDuckLabel = driver.findElement(By.xpath("//*[@title='Green Duck']/*/*[@class='sticker new']"));

        Assert.assertEquals(greenDuckLabel.getText(), "NEW");

        driver.quit();
    }

    @Test
    void yellowDuckLabelTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksMenuButton = driver.findElement(By.cssSelector("#site-menu .category-1"));
        WebElement subcategoryMenuButton = driver.findElement(By.cssSelector("#site-menu .category-2 a"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksMenuButton)
                .click(subcategoryMenuButton)
                .perform();

        WebElement greenDuckLabel = driver.findElement(By.xpath("//*[@title='Yellow Duck']/*/*[@class='sticker sale']"));

        Assert.assertEquals(greenDuckLabel.getText(), "SALE");

        driver.quit();
    }
}
