package pageobject.pagefactory.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubcategoryPagePF {
    @FindBy(xpath = "//*[@class='button'][text()='Name']")
    private WebElement nameButton;

    @FindBy(xpath = "//*[@title='Green Duck']/*/*[@class='sticker new']")
    private WebElement greenDuckLabelText;

    @FindBy(xpath = "//*[@title='Yellow Duck']/*/*[@class='sticker sale']")
    private WebElement yellowDuckLabelText;

    public void nameButtonClick() {
        nameButton.click();
    }

    public String greenDuckLabelText() {
        return greenDuckLabelText.getText();
    }

    public String yellowDuckLabelText() {
        return yellowDuckLabelText.getText();
    }
}
