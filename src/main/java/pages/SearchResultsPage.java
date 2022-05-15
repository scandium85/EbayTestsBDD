package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']/span")
        private List<WebElement> resultsTitle;

    @FindBy(xpath = "//ul//h3[@class='s-item__title']")
    private List<WebElement> listTitleProducts;

    @FindBy(xpath = "//a[@class='pagination__next icon-link']")
        private WebElement nextPageArrow;

    @FindBy(xpath = "//ul//li[contains(@class,'s-item s-item__pl-on-bottom')]")
    private List<WebElement> amountProductsOnPage;

    @FindBy(xpath = "//div[@class='srp-ipp']//span[@class='expand-btn__cell']/span/span/span")
    private WebElement itemPerPageSelector;

    @FindBy(xpath = "//div[@class='x-refine-toggle']")
    private List<WebElement> listToggleFilters;

    @FindBy(xpath = "//div[@class='x-refine__group']")
    private List<WebElement> listItemsForFilters;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getContainsResultsTitle(){
        return resultsTitle.get(1).getText();
    }

    public void clickNextPageArrow(){
        nextPageArrow.click();
    }

    public int getAmountProductsOnPage(){
        return amountProductsOnPage.size();
    }

    public int getNumberItemPerPageSelector(){
        return Integer.parseInt(itemPerPageSelector.getText());
    }

    public boolean getUrlContainsNumberSecondPage(){
        return driver.getCurrentUrl().contains("pgn=2");
    }

    public int amountItemToggleFilters(){
        return listToggleFilters.size();
    }

    public void clickItemToggleFilters(final int item){
        listToggleFilters.get(item).click();
    }

    public boolean isVisibilityItemsForFilters(final int item){
        return listItemsForFilters.get(item).isDisplayed();
    }

    public WebElement getFirstTitleProducts(){
        return listTitleProducts.get(0);
    }

    public void clickFirstTitleProducts(){
        listTitleProducts.get(0).click();
    }

}
