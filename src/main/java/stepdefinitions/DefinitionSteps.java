package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 30;

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    DetailProductPage detailProductPage;
    CartPage cartPage;
    CreateAccountPage createAccountPage;
    CollectiblesPage collectiblesPage;
    CheckoutPage checkoutPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @After
    public void tearDown(){ driver.quit();}

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User checks that result title contains {string}")
    public void checkThatTitleSearchContainsKeyword(final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertEquals(keyword, searchResultsPage.getContainsResultsTitle());
    }

    @And("User clicks first product of daily deals")
    public void clickFirstProductOfDailyDeals() {
        homePage.clickFirstProductOfDailyDeals();
    }

    @And("User clicks add to cart button")
    public void clickAddToCartButton() {
        detailProductPage = pageFactoryManager.getDetailProductPage();
        detailProductPage.waitVisibilityOfElement(DEFAULT_TIMEOUT
                , detailProductPage.getBuyButton());
        detailProductPage.clickBuyButton();
    }

    @And("User checks that amount of products in the icon cart and in the cart title")
    public void checkThatAmountOfProductsInTheIconCartAndInTheCartTitle() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getCountItemOfCartIcon());
        assertEquals(1, cartPage.countProductInCart());
        assertTrue(cartPage.countProductInTitle());
    }

    @And("User clicks remove item from cart")
    public void clicksRemoveItemFromCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getRemoveButton());
        cartPage.clickRemoveButton();
    }

    @And("User checks massage {string} cart")
    public void checkMassageAboutRemoveItemFromCart(final String massage) {
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getEmptyCart());
        assertEquals(massage, cartPage.textMassageRemoveFromCart());
    }

    @And("User clicks registration button")
    public void clickRegistrationButton() {
        homePage.clickRegistrationButton();
    }

    @And("User enters incorrect {string} email")
    public void enterIncorrectEmail(final String email) {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.enterTextToEmailField(email);
    }

    @And("User clicks password field")
    public void clickPasswordField() {
        createAccountPage.clickPasswordField();
    }

    @And("User checks massage {string} hint for email")
    public void checkMassageTextHintForEmail(final String massage) {
        createAccountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT
                , createAccountPage.getErrorEmailMassage());
        assertEquals(massage, createAccountPage.textErrorEmailMassage());
    }

    @And("User enters incorrect {string} password")
    public void enterIncorrectPassword(final String password) {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.enterTextToPasswordField(password);
    }

    @And("User clicks email field")
    public void clicksEmailField() {
        createAccountPage.clickEmailField();
    }

    @And("User checks massage {string} hint for password")
    public void checkMassageTextHintForPassword(final String massage) {
        createAccountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT
                , createAccountPage.getErrorPasswordMassage());
        assertEquals(createAccountPage.textErrorPasswordMassage(), massage);
    }

    @And("User checks that number of products on the page is equals item per page selector")
    public void checkThatNumberOfProductsPageIsEqualsToItemPerPageSelector() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertEquals(searchResultsPage.getAmountProductsOnPage()
                , searchResultsPage.getNumberItemPerPageSelector());
    }

    @And("User clicks next page arrow")
    public void clickNextPageArrow() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickNextPageArrow();
    }

    @And("User checks that url contains new number page")
    public void checkThatUrlContainsNewNumberPage() {
        assertTrue(searchResultsPage.getUrlContainsNumberSecondPage());
    }

    @And("User checks dropdown visibility for Categories of search field")
    public void checkDropdownVisibilityForCategoriesOfSearchField() {
        homePage.clickCategorySearchFieldButton();
        homePage.isVisibilityFirstCategorySearchFieldDropdown();
    }

    @And("User checks dropdown visibility for My eBay")
    public void checkDropdownVisibilityForMyEBay() {
        homePage.moveToMyEbayMenu();
        homePage.isVisibilityMyEbaySubmenu();
    }

    @And("User checks dropdown visibility for all items of main menu")
    public void checkDropdownVisibilityForAllItemsOfMainMenu() {
        int sizeMenu = homePage.sizeMainMenu();
        for (int i = 0; i < sizeMenu - 1; i++) {
            homePage.moveItemMainMenu(i);
            homePage.isVisibilitySubmenuItemMainMenu(i);
        }
    }

    @And("User checks dropdown visibility for Shop by category")
    public void checkDropdownVisibilityForShopByCategory() {
        homePage.clickShopByCategoriesButton();
        assertTrue(homePage.isVisibilityShopByCategoriesDropdown());
    }

    @And("User clicks Collectibles category of Shop by category")
    public void clickCollectiblesOfShopByCategory() {
        homePage.clickCollectiblesOfShopByCategory();
    }


    @And("User checks that current category matches Collectibles")
    public void checkThatCurrentCategoryMatchesCollectibles() {
        collectiblesPage = pageFactoryManager.getCollectiblesPage();
        assertEquals("Collectibles", collectiblesPage.getNameCategoryPage());
    }

    @And("User checks visibility all items of filters by toggle of filters")
    public void checkVisibilityAllItemsOfFiltersByToggleOfFilters() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        for (int i = 0; i < searchResultsPage.amountItemToggleFilters(); i++) {
            searchResultsPage.isVisibilityItemsForFilters(i);
            searchResultsPage.clickItemToggleFilters(i);
            assertFalse(searchResultsPage.isVisibilityItemsForFilters(i));
        }
    }

    @And("User clicks Buy It Now button")
    public void clickBuyItNowButton() {
        detailProductPage = pageFactoryManager.getDetailProductPage();
        detailProductPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, detailProductPage.getBuyItNowButton());
        detailProductPage.clickBuyItNowButton();
    }

    @And("User checks visibility Check out as guest button on a popup")
    public void checkVisibilityCheckOutAsGuestButtonOnPopup() {
        detailProductPage.waitVisibilityOfElement(DEFAULT_TIMEOUT
                , detailProductPage.getCheckOutAsGuestButton());
        detailProductPage.isVisibilityCheckOutAsGuestButton();
    }

    @And("User clicks Check out as guest button on a popup")
    public void clickCheckOutAsGuestButtonOnPopup() {
        detailProductPage.clickCheckOutAsGuestButton();
    }

    @And("User checks that title current page is {string}")
    public void checkThatCurrentPageIsCheckout(final String title) {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        assertEquals(title, checkoutPage.getTextTitleCheckoutPage());
    }

    @And("User clicks first product of list search result page")
    public void clickFirstProductOfListSearchResultPage() throws InterruptedException {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT
                , searchResultsPage.getFirstTitleProducts());
        searchResultsPage.clickFirstTitleProducts();
        searchResultsPage.selectNewOpenedPage();
    }
}
