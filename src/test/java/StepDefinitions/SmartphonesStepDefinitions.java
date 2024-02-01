package StepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static POM.ElementsMap.elementsMap;
import static enums.ExpectedConditionType.VISIBLE;

public class SmartphonesStepDefinitions extends BaseMethods {
    List<WebElement> products;

    @Then("Product {string} name should be displayed in new page")
    public void productSubcategoryPageCheck(String text) {
        Assert.assertEquals(driver.findElement(elementsMap.get("productSubCategoryName")).getText(), text);
    }

    @Then("Products associated to selected {string} should be displayed")
    public void productsRelatedToShouldBeDisplayed(String text) {
        products = driver.findElements(elementsMap.get("productName"));
        for (WebElement element : products){
            Assert.assertTrue(element.getText().toUpperCase().contains(text.toUpperCase()));
        }
    }
}
