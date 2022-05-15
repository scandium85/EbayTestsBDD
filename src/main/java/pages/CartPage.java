package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//i[@id='gh-cart-n']")
    private WebElement countItemOfCartIcon;

    @FindBy(xpath = "//h1[@class='main-title']")
    private WebElement countItemTitle;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@class='page-notice__main']//span/span/span")
    private WebElement pathMassageRemove;

    @FindBy(xpath = "//div[@class='empty-cart']")
    private WebElement emptyCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCountItemOfCartIcon(){
        return countItemOfCartIcon;
    }

    public int countProductInCart(){
        return Integer.parseInt(countItemOfCartIcon.getText());
    }

    public boolean countProductInTitle(){
        return countItemTitle.getText().contains("1");
    }

    public String textMassageRemoveFromCart(){
        return pathMassageRemove.getText();
    }

    public WebElement getRemoveButton(){
        return removeButton;
    }

    public void clickRemoveButton(){
        removeButton.click();
    }

    public WebElement getEmptyCart(){
        return emptyCart;
    }

}
