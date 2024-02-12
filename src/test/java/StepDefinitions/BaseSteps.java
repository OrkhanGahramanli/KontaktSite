package StepDefinitions;

import enums.ExpectedConditionType;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

import static POM.ElementsMap.elementsMap;
import static enums.ExpectedConditionType.*;

public class BaseSteps extends BaseMethods {

    List<WebElement> list = new ArrayList<>();
    List<WebElement> products;
    WebElement selectedProduct;
    int selectedProductIndex;
    List<WebElement> productDetailsOnHover;
    List<String> tabs;
    List<WebElement> productLink;
    List<WebElement> productsPrices;
    int productsAddedToBasketCount;
    String checkboxCount;
    @After
    public void afterScenario() {
        if (productsAddedToBasketCount!=0) productsAddedToBasketCount=0;
    }

    @Given("User is in Home Page")
    public void userIsInHomePage() {
        getJsExecutor().executeScript("arguments[0].click();",
                driver.findElement(By.cssSelector(".action.secondary")));
    }

    @When("User selects {string} from {string}")
    public void userSelectsFrom(String text, String elements) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        list = driver.findElements(elementsMap.get(elements));
        for (WebElement element : list) {
            if (element.getAttribute("innerText").replace("\"", "").equals(text)) {
                try {
                    element.click();
                } catch (ElementNotInteractableException e ) {
                    getJsExecutor().executeScript("arguments[0].click();", element);
                }
                break;
            }
        }
    }

    @And("User inputs {string} price in {string} and {string} price in {string} from filter")
    public void userSelectsPriceAndPriceFromFilter(String minPriceText, String minPriceElement, String maxPriceText, String maxPriceElement) {
        driver.findElement(elementsMap.get(minPriceElement)).clear();
        driver.findElement(elementsMap.get(minPriceElement)).sendKeys(minPriceText);
        explicitWait(elementsMap.get(maxPriceElement), PRESENCE, 20);
        driver.findElement(elementsMap.get(maxPriceElement)).clear();
        explicitWait(elementsMap.get(maxPriceElement), PRESENCE, 20);
        driver.findElement(elementsMap.get(maxPriceElement)).sendKeys(maxPriceText);
    }

    @Then("Products between {string} price and {string} price should be displayed")
    public void productsWithPriceAndPriceShouldBeDisplayed(String minPrice, String maxPrice) throws InterruptedException {
        Thread.sleep(5000);
        productsPrices = driver.findElements(elementsMap.get("productsPrices"));
        if (!productsPrices.isEmpty()){
        for (WebElement element : productsPrices) {
            Assert.assertTrue(Double.parseDouble(element.getText().split(" ")[0].replace(".", "")
                    .replace(",", "."))
                    >= Double.parseDouble(minPrice)
                    && Double.parseDouble(element.getText().split(" ")[0].replace(".", "")
                    .replace(",", "."))
                    <= Double.parseDouble(maxPrice));
            }
        }
        else Assert.assertTrue(true);
    }

    @And("User clicks {string} buttons")
    public void userClicksButtons(String elements) throws InterruptedException {
        if (elements.equals("addToBasketBtn")){
            List<WebElement> addToBasketElements = driver.findElements(elementsMap.get(elements));
            for (int i=0; i<selectedProductIndex; i++){
                getJsExecutor().executeScript("arguments[0].click();", addToBasketElements.get(i));
                productsAddedToBasketCount++;
                Thread.sleep(1000);
            }
        }
        else if (elements.equals("showMoreButton")){
        List<WebElement> showMoreBtns;
        showMoreBtns = driver.findElements(elementsMap.get(elements));
        for (WebElement element : showMoreBtns){
            try {
                if (element.isDisplayed()) element.click();
            }catch (ElementClickInterceptedException e) {
                getJsExecutor().executeScript("arguments[0].click();", element);
                }
            }
            Thread.sleep(1000);
        }else {
            List<WebElement> list = driver.findElements(elementsMap.get(elements));
            for (WebElement element : list){
                explicitWait(element, CLICKABLE, 10);
                getJsExecutor().executeScript("arguments[0].click();", element);
            }
        }
    }

    @Then("Products associated to selected {string} should be displayed")
    public void productsRelatedToShouldBeDisplayed(String text) {
        products = driver.findElements(elementsMap.get("productName"));
        for (WebElement element : products){
            Assert.assertTrue(element.getText().toUpperCase().contains(text.toUpperCase()));
        }
    }

    @And("User selects any product")
    public void userSelectsAnyProduct() {
        productLink = driver.findElements(elementsMap.get("productLink"));
        selectedProductIndex = (int) (Math.random()*productLink.size());
        selectedProduct = productLink.get(selectedProductIndex);
        explicitWait(selectedProduct, CLICKABLE, 20);
        clickAction(selectedProduct);
    }

    @And("User clicks {string} button at all filters")
    public void userExpandAllFilters(String elements) {
        List<WebElement> expandBtn = driver.findElements(elementsMap.get(elements));
        explicitWaitList(expandBtn, VISIBLE, 20);
        for (WebElement element : expandBtn){
            getJsExecutor().executeScript("arguments[0].click();", element);
        }
    }

    @Then("Product {string} which contains {string} should be displayed")
    public void productDetailsWhichContainsShouldBeDisplayed(String element, String text) {
        products = driver.findElements(elementsMap.get("productName"));
        moveToElement(products.get(selectedProductIndex));
        productDetailsOnHover = driver.findElements(elementsMap.get(element));
        Assert.assertEquals(productDetailsOnHover.get(selectedProductIndex).getText().replace("\"", ""), text);
    }

    @Then("Verify {string} in {string} in product specifications")
    public void verifyInProductSpecifications(String text, String element) {
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.findElement(elementsMap.get(element)).getText().replace("\"", ""), text);
    }

    @And("User clicks {string} button")
    public void userClicksButton(String element) {
        if (element.equals("showAllProductBtn")) {
            try {
                WebElement showMoreProducts = driver.findElement(elementsMap.get(element));
                while (showMoreProducts.isDisplayed()) {
                    getJsExecutor().executeScript("arguments[0].click();", showMoreProducts);
                    Thread.sleep(1000);
                }
            }catch (NoSuchElementException | InterruptedException ignored){
                System.out.println("Products count less or equals 20");
            }
        }
        else clickAction(driver.findElement(elementsMap.get(element)));

    }

    @And("User moves to another tab")
    public void userMovesToAnotherTab() {
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @Then("Selected products count should be displayed on {string}")
    public void productsCountShouldBeDisplayedOnBasketBtn(String element) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(elementsMap.get(element)).getAttribute("data-items-count")
                             , String.valueOf(productsAddedToBasketCount));
    }

    @Then("Product should be displayed in {string}")
    public void productShouldBeDisplayedIn(String element) {
        Assert.assertTrue(driver.findElement(elementsMap.get(element)).isDisplayed());
    }

    @And("User hovers to a product")
    public void userHoversToAProduct() {
        productLink = driver.findElements(elementsMap.get("productLink"));
        selectedProductIndex = (int) (Math.random()*productLink.size());
        selectedProduct = productLink.get(selectedProductIndex);
        moveToElement(selectedProduct);
    }

    @Then("{string} message should be displayed in {string}")
    public void messageShouldBeDisplayedIn(String text, String element) {
        explicitWait(elementsMap.get(element), VISIBLE, 10);
        Assert.assertEquals(driver.findElement(elementsMap.get(element)).getText(), text);
    }

    @And("User selects any filter \\({string})")
    public void userSelectsAnyFilter(String element) {
        List <WebElement> allCheckBoxFilters = driver.findElements(elementsMap.get(element));
        int selectedCheckBoxFilter = (int) (Math.random()*allCheckBoxFilters.size());
        checkboxCount = allCheckBoxFilters.get(selectedCheckBoxFilter).getAttribute("innerText")
                .replace("(", "").replace(")","");
        getJsExecutor().executeScript("arguments[0].click();", allCheckBoxFilters.get(selectedCheckBoxFilter));
    }

    @Then("Products count should equals {string}")
    public void productsCountShouldEquals(String element) {
        products = driver.findElements(elementsMap.get("productLink"));
        Assert.assertEquals(products.size(),
                Integer.parseInt(checkboxCount));
    }

    @Then("Product {string} name should be displayed in new page")
    public void productSubcategoryPageCheck(String text) {
        Assert.assertEquals(driver.findElement(elementsMap.get("productSubCategoryName")).getText(), text);
    }

    @Then("Each {string} should be {int}")
    public void eachProductCountShouldBe(String elements, int num) {
        List<WebElement> productsCount = driver.findElements(elementsMap.get(elements));
        for (WebElement element : productsCount) {
            Assert.assertEquals(element.getAttribute("value"), "2");
        }
    }
}
