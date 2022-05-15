package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CollectiblesPage extends BasePage{

    @FindBy(xpath = "//span[@class='b-pageheader__text']")
    private WebElement nameCategoryPage;

    public CollectiblesPage(WebDriver driver) {
        super(driver);
    }

    public String getNameCategoryPage(){
        return nameCategoryPage.getText();
    }
}
