package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@id='Email_err']")
    private WebElement errorEmailMassage;

    @FindBy(xpath = "//span[@id='password_err']")
    private WebElement errorPasswordMassage;


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickEmailField(){
        emailField.click();
    }

    public void enterTextToEmailField(final String text){
        emailField.sendKeys(text);
    }

    public WebElement getErrorEmailMassage(){
        return errorEmailMassage;
    }

    public String textErrorEmailMassage() {
        return errorEmailMassage.getText();
    }

    public void clickPasswordField(){
        passwordField.click();
    }

    public void enterTextToPasswordField(final String text){
        passwordField.sendKeys(text);
    }

    public WebElement getErrorPasswordMassage(){
        return errorPasswordMassage;
    }

    public String textErrorPasswordMassage() {
        return errorPasswordMassage.getText();
    }
}
