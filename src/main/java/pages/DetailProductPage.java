package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class DetailProductPage extends BasePage{

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement buyButton;

    @FindBy(xpath = "//a[@id='binBtn_btn']")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//button[@id='sbin-gxo-btn']")
    private WebElement checkOutAsGuestButton;

    public DetailProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBuyButton(){
        return buyButton;
    }

    public void clickBuyButton(){
        buyButton.click();
    }

    public WebElement getBuyItNowButton(){
        return buyItNowButton;
    }

    public void clickBuyItNowButton(){
        buyItNowButton.click();
    }

    public WebElement getCheckOutAsGuestButton(){
        return checkOutAsGuestButton;
    }

    public boolean isVisibilityCheckOutAsGuestButton(){
        return checkOutAsGuestButton.isDisplayed();
    }

    public void clickCheckOutAsGuestButton(){
        checkOutAsGuestButton.click();
    }
}
