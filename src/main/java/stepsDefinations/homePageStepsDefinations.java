package stepsDefinations;

import com.cucumber.BaseTest.baseTest;
import com.cucumber.pages.cartPage;
import com.cucumber.pages.homePage;
import com.cucumber.pages.pdpPage;
import com.cucumber.pages.searchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class homePageStepsDefinations extends baseTest {
    public homePageStepsDefinations() throws IOException {
        super();
    }
    homePage homepage;
    searchPage searchpage;
    pdpPage pdppage;
    cartPage cartpage;

    @Before
    public void setUp() throws IOException {
        initializ();
        homepage=new homePage();
    }
    @Given("Home page check logo")
    public void home_page_check_logo() {
        homepage.pageLogo();
    }
    @When("home page all elements are plesent")
    public void home_page_all_elements_are_plesent() {
        homepage.checkWishList();

    }

    @When("Enter query in search box and press enter key")
    public void enter_query_in_search_box_and_press_enter_key() throws IOException {
        searchpage=homepage.checkSearchHomePage();
    }
    @Then("check the search result page")
    public void check_the_search_result_page() {
            System.out.println(searchpage.checkSearchMessage());
    }

    @Given("Home page url {string}")
    public void home_page_url(String url) {
        String currentPageUrl=driver.getCurrentUrl();
        Assert.assertEquals("URL is not homepage url",url,currentPageUrl) ;
    }
    @When("Click add to cart button from product")
    public void click_add_to_cart_button_from_product() throws InterruptedException {
        homepage.addToCartInHomePage();
    }
    @Then("Click on cart")
    public void click_on_cart() {
            homepage.cartClick();
    }
    @And("validate the product from cart")
    public void validate_the_product() {
        homepage.validateCartProductTitle();

    }
    @When("click product in Home page")
    public void click_product_in_home_page() throws IOException {
        pdppage=homepage.clickProductInHomepage();
    }
    @Then("validate the PDP page")
    public void validate_the_PDP_page() {
        pdppage.checkProductDescription();
    }
    @When("Click on account tab")
    public void click_on_account_tab() throws InterruptedException {
        homepage.accountClick();
    }
    @Then("Enter user and pass and click on login")
    public void enter_user_and_pass_and_click_on_login() throws IOException, InterruptedException {
        homepage.loginUser();
    }
    @And("validate the user name")
    public void validate_the_user_name() throws InterruptedException {
            homepage.checkUserProfile();
    }

    @When("Search query and go to the SRP")
    public void search_query_and_go_to_the_srp() throws IOException {
           searchpage=homepage.checkSearchHomePage();
    }
    @Then("Click any product from SRP and go to the PDP")
    public void click_any_product_from_srp_and_go_to_the_pdp() throws IOException {
        pdppage=searchpage.clickProductOnSRP();
    }
    @Then("Increase the qty of the product")
    public void increase_the_qty_of_the_product() {
        pdppage.increaseProductQty();
    }
    @Then("Click add to card")
    public void click_add_to_card() throws InterruptedException {
        pdppage.clickADDtoCartPDP();
    }
    @Then("Click on cart icon and validate the product")
    public void click_on_cart_icon_and_validate_the_product() {
        pdppage.pdpCartProductCheck();
    }
    @Then("go to the cart page")
    public void go_to_the_cart_page() throws IOException {
        cartpage=pdppage.clickCartPageButton();
    }
    @Then("click on delete icon form cart list")
    public void click_on_delete_icon_form_cart_list() {
        cartpage.clickOnDelete();
    }
    @Then("validate product is deleted or not")
    public void validate_product_is_deleted_or_not() {
        cartpage.validateDeleteMessage();
    }
    @After
    public void tearDown()
    { driver.close(); }
}
