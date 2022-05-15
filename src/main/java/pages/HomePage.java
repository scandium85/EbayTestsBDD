package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@class='gh-tb ui-autocomplete-input'] ")
    private WebElement searchField;

    @FindBy(xpath = "//input[@class='btn btn-prim gh-spr']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class='hl-carousel__item hl-standard-carousel__item']")
    private List<WebElement> listDailyDeals;

    @FindBy(xpath = "//a[text()='register']")
    private WebElement registrationButton;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categorySearchFieldButton;

    @FindBy(xpath = "//select[@id='gh-cat']/option")
    private List<WebElement> categorySearchFieldDropdown;

    @FindBy(xpath = "//li[@class='gh-eb-li gh-dd rt']")
    private WebElement myEbayMenu;

    @FindBy(xpath = "//div[@class='gh-submenu gh-eb-o']")
    private WebElement myEbaySubmenu;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']")
    private List<WebElement> categoriesMainMenu;

    @FindBy(xpath = "//div[@class='hl-cat-nav__sub-cats']")
    private List<WebElement> submenuMainMenu;

    @FindBy(xpath = "//button[@id='gh-shop-a']")
    private WebElement shopByCategoriesButton;

    @FindBy(xpath = "//div[@id='gh-sbc-o']")
    private WebElement shopByCategoriesDropdown;

    @FindBy(xpath = "//table[@id='gh-sbc']//a[text()='Collectibles']")
    private WebElement collectiblesCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage (String url) { driver.get(url);}


    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickFirstProductOfDailyDeals(){
        listDailyDeals.get(0).click();
    }

    public void clickRegistrationButton(){
        registrationButton.click();
    }

    public void clickCategorySearchFieldButton(){
        categorySearchFieldButton.click();
    }

    public boolean isVisibilityFirstCategorySearchFieldDropdown(){
        return categorySearchFieldDropdown.get(0).isDisplayed();
    }

    public void moveToMyEbayMenu(){
        new Actions(driver).moveToElement(myEbayMenu).perform();
    }

    public boolean isVisibilityMyEbaySubmenu(){
        return myEbaySubmenu.isSelected();
    }

    public int sizeMainMenu(){
        return categoriesMainMenu.size();
    }

    public void moveItemMainMenu(final int item){
        new Actions(driver).moveToElement(categoriesMainMenu.get(item)).perform();
    }

    public boolean isVisibilitySubmenuItemMainMenu(final int item){
        return submenuMainMenu.get(item).isDisplayed();
    }

    public void clickShopByCategoriesButton(){
        shopByCategoriesButton.click();
    }

    public boolean isVisibilityShopByCategoriesDropdown(){
        return shopByCategoriesDropdown.isDisplayed();
    }

    public void clickCollectiblesOfShopByCategory(){
        collectiblesCategory.click();
    }
}
