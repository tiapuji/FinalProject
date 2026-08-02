package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.WebPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helper.Utility.driver;

public class WebStep {

    WebPage webPage;

    public WebStep(){
        this.webPage = new WebPage();
    }

    @Given("open web login page")
    public void openWebLoginPage() {
        webPage.openBrowser();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.input_username(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String pwd) {
        webPage.input_pwd(pwd);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.clickBtnLogin();
    }

    @And("user will see icon cart")
    public void userWillSeeIconCart() {
        webPage.assertHomePage();
    }

    @And("user will see err message {string}")
    public void userWillSeeErrMessage(String errMsg) {
        webPage.assertErrMsg(errMsg);
     //   System.out.println(errMsg);
    }

    @And("user add item to cart")
    public void userAddItemToCart() {
        webPage.clickAddToCart();
    }

    @And("verify cart item is match {string}")
    public void verifyCartItemIsMatch(String cartItem) {
        webPage.assertCartItem(cartItem);
    }

    @And("user remove item to cart")
    public void userRemoveItemToCart() {
        webPage.removeAddToCart();
    }

    @And("user open shopping cart")
    public void openCart(){
        webPage.openCart();
    }

    @And("user click checkout button")
    public void checkout(){
        webPage.clickCheckout();
    }

    @And("user input checkout firstname {string}")
    public void inputFirstname(String name){
        webPage.inputFirstname(name);
    }

    @And("user input checkout lastname {string}")
    public void inputLastname(String name){
        webPage.inputLastname(name);
    }

    @And("user input checkout postal code {string}")
    public void inputPostal(String code){
        webPage.inputPostalCode(code);
    }

    @And("user click continue button")
    public void clickContinue(){
        webPage.clickContinue();
    }

    @Then("user should see checkout overview page")
    public void verifyOverview(){
        webPage.verifyOverviewPage();
    }

    @When("user click finish button")
    public void clickFinish(){
        webPage.clickFinish();
    }

    @Then("user should see checkout success message {string}")
    public void verifySuccess(String message){
        webPage.verifySuccessMessage(message);
    }

    @When("user select sort by name Z to A")
    public void userSelectSortByNameZToA() {
        webPage.sortByNameZtoA();
    }

    @Then("verify product sorted alphabetically by name from Z to A")
    public void verify_product_sorted_alphabetically_by_name_from_Z_to_A() {
        webPage.verifyProductSortedZToA();
    }

    @When("user select sort by name A to Z")
    public void userSelectSortByNameAToZ() {
        webPage.sortByNameAtoZ();

    }

    @Then("verify product sorted alphabetically by name from A to Z")
    public void verifyProductSortedAlphabeticallyByNameFromAToZ() {
        webPage.verifyProductSortedAToZ();
    }

    @When("user select sort by price high to low")
    public void userSelectSortByPriceHighToLow() {
        webPage.sortByPriceHiLo();
    }

    @Then("verify product sorted alphabetically by name from high to low")
    public void verifyProductSortedAlphabeticallyByNameFromHighToLow() {
        webPage.verifyProductSortedHiLo();
    }

    @When("user select sort by price low to high")
    public void userSelectSortByPriceLowToHigh() {
        webPage.sortByPriceLoHi();
    }

    @Then("verify product sorted alphabetically by name from low to high")
    public void verifyProductSortedAlphabeticallyByNameFromLowToHigh() {
        webPage.verifyProductSortedLoHi();
    }
}
