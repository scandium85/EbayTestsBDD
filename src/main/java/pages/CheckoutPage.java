package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement titleCheckoutPage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTextTitleCheckoutPage(){
        return titleCheckoutPage.getText();
    }
}
