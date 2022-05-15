package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() { return new HomePage(driver);}

    public SearchResultsPage getSearchResultsPage() { return new SearchResultsPage(driver);}

    public DetailProductPage getDetailProductPage() { return new DetailProductPage(driver);}

    public CartPage getCartPage() { return new CartPage(driver);}

    public CreateAccountPage getCreateAccountPage() { return new CreateAccountPage(driver);}

    public CollectiblesPage getCollectiblesPage() { return new CollectiblesPage(driver);}

    public CheckoutPage getCheckoutPage() { return new CheckoutPage(driver);}
}
