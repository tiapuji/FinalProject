package pages;

import org.openqa.selenium.By;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

import static helper.Utility.driver;

public class WebPage {
    By input_username = By.id("user-name");

    By input_pwd = By.id("password");

    By btn_login = By.id("login-button");

    By icon_cart = By.xpath ("//a[@class='shopping_cart_link']");

    By icon_cart_item = By.xpath("//span[@class='shopping_cart_badge']");

    By addToCart = By.xpath("(//*[text()='Add to cart'])[1]");

    By removeToCart = By.xpath("(//*[text()='Remove'])[1]");

    By sortItem = By.xpath("//select");

    By sortItemZtoA = By.xpath("//option[@value=\"za\"]");

    By sortItemAtoZ = By.xpath("//option[@value=\"az\"]");

    By sortItemHiLo = By.xpath("//option[@value=\"hilo\"]");

    By sortItemLoHi = By.xpath("//option[@value=\"lohi\"]");

    By productNames = By.className("inventory_item_name");

    By productPrices = By.className("inventory_item_price");

    By checkoutBtn = By.id("checkout");

    By firstname = By.id("first-name");

    By lastname = By.id("last-name");

    By postalCode = By.id("postal-code");

    By continueBtn = By.id("continue");

    By finishBtn = By.id("finish");

    By successMessage = By.className("complete-header");

    By overviewTitle = By.className("title");

    By text_err_msg (String msg){
        return By.xpath("//*[contains(text(),'"+ msg + "')]");
    }

    public void openBrowser(){
        driver.get("https://www.saucedemo.com/");
        System.out.println("URL : " + driver.getCurrentUrl());
    }

    public void input_username(String username){
        driver.findElement(input_username).sendKeys(username);
        System.out.println("Input username: " + username);
    }

    public void input_pwd(String pwd){
        driver.findElement(input_pwd).sendKeys(pwd);
        System.out.println("Input password: " + pwd);
    }

    public void clickBtnLogin(){
        driver.findElement(btn_login).click();

        System.out.println("Click button login");
    }

    public void assertHomePage(){
        boolean isDisplayed = driver.findElement(icon_cart).isDisplayed();

        System.out.println("Verify homepage");
        System.out.println("Cart icon displayed: " + isDisplayed);

        Assertions.assertThat(isDisplayed).isTrue();
    }

    public void assertErrMsg (String errmsg){
        boolean isDisplayed = driver.findElement(text_err_msg(errmsg)).isDisplayed();

        System.out.println("Verify error message");
        System.out.println("Expected error message: " + errmsg);
        System.out.println("Error message displayed: " + isDisplayed);

        Assertions.assertThat(isDisplayed).isTrue();
    }

    public void clickAddToCart (){
        System.out.println("Click Add To Cart button");

        driver.findElement(addToCart).click();
        String badge = driver.findElement(icon_cart_item).getText();

        System.out.println("Cart badge = " + badge);
    }

    public void removeAddToCart (){
        System.out.println("Click Remove button");

        driver.findElement(removeToCart).click();

        String badge = driver.findElement(icon_cart_item).getText();
        System.out.println("Remove cart badge = " + badge);
    }

    public void assertCartItem (String cartItem){
        String itemExpected = cartItem;
        String itemActual = driver.findElement(icon_cart_item).getText();

        System.out.println("Verify cart item");
        System.out.println("Item Expected : [" + itemExpected + "]");
        System.out.println("Item Actual   : [" + itemActual + "]");

        Assertions.assertThat(itemActual).isEqualTo(itemExpected);
    }

    public void openCart(){
        System.out.println("Open shopping cart");
        driver.findElement(icon_cart).click();
    }

    public void clickCheckout(){
        driver.findElement(checkoutBtn).click();
        System.out.println("Click checkout");
    }

    public void inputFirstname(String name){
        driver.findElement(firstname).sendKeys(name);
        System.out.println("Input first name : " + firstname);
    }

    public void inputLastname(String name){
        driver.findElement(lastname).sendKeys(name);
        System.out.println("Input lastname: " + lastname);
    }

    public void inputPostalCode(String code){
        driver.findElement(postalCode).sendKeys(code);
        System.out.println("Input postal code : " + postalCode);
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
        System.out.println("Click continue");
    }

    public void verifyOverviewPage(){
        String title = driver.findElement(overviewTitle).getText();
        System.out.println("Page title : " + title);
        Assertions.assertThat(title).isEqualTo("Checkout: Overview");
    }

    public void clickFinish(){
        driver.findElement(finishBtn).click();
        System.out.println("Click finish button");
    }

    public void verifySuccessMessage(String message){
        String actual = driver.findElement(successMessage).getText();
        System.out.println("Expected : " + message);
        System.out.println("Actual   : " + actual);
        Assertions.assertThat(actual).isEqualTo(message);
    }

    public void assertCheckoutSuccess(String message){

        String actual = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOfElementLocated(successMessage))
                        .getText();
        System.out.println("Expected : " + message);
        System.out.println("Actual   : " + actual);

        Assertions.assertThat(actual).isEqualTo(message);
    }

    public void sortByNameZtoA () {

        driver.findElement(sortItem).click();
        driver.findElement(sortItemZtoA).click();
        String selectedSort = driver.findElement(sortItemZtoA).getText();

        System.out.println("Sort By: " + selectedSort);
    }

    public void sortByNameAtoZ () {

        driver.findElement(sortItem).click();
        driver.findElement(sortItemAtoZ).click();
        String selectedSort = driver.findElement(sortItemAtoZ).getText();

        System.out.println("Sort By: " + selectedSort);

    }

    public List<String> getProductNames() {

        List<WebElement> products = driver.findElements(productNames);
        List<String> names = new ArrayList<>();

        for (WebElement product : products) {
            names.add(product.getText());
        }
        return names;
    }

    public void verifyProductSortedZToA() {

        List<String> actual = getProductNames();

        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected, Collections.reverseOrder());

        System.out.println("Actual   : " + actual);
        System.out.println("Expected : " + expected);

        assertThat(actual).isEqualTo(expected);
    }

    public void verifyProductSortedAToZ() {

        List<String> actual = getProductNames();

        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected);

        System.out.println("Actual   : " + actual);
        System.out.println("Expected : " + expected);

        assertThat(actual).isEqualTo(expected);
    }
    public void sortByPriceHiLo () {

        driver.findElement(sortItem).click();
        driver.findElement(sortItemHiLo).click();
        String selectedSort = driver.findElement(sortItemHiLo).getText();

        System.out.println("Sort By: " + selectedSort);

    }

    public List<String> getProductPrices() {

        List<WebElement> products = driver.findElements(productPrices);
        List<String> names = new ArrayList<>();

        for (WebElement product : products) {
            names.add(product.getText());
        }

        return names;
    }

    public void verifyProductSortedHiLo() {

        List<String> actual = getProductPrices();

        List<Double> actualPrices = actual.stream()
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder());

        System.out.println("Actual   : " + actualPrices);
        System.out.println("Expected : " + expectedPrices);

        assertThat(actualPrices).isEqualTo(expectedPrices);
    }
    public void sortByPriceLoHi () {

        driver.findElement(sortItem).click();
        driver.findElement(sortItemLoHi).click();
        String selectedSort = driver.findElement(sortItemLoHi).getText();

        System.out.println("Sort By: " + selectedSort);

    }

    public void verifyProductSortedLoHi() {

        List<String> actual = getProductPrices();

        List<Double> actualPrices = actual.stream()
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        System.out.println("Actual   : " + actualPrices);
        System.out.println("Expected : " + expectedPrices);

        assertThat(actualPrices).isEqualTo(expectedPrices);
    }
}