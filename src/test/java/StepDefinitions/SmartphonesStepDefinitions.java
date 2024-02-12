package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static POM.ElementsMap.elementsMap;
import static enums.ExpectedConditionType.*;

public class SmartphonesStepDefinitions extends BaseMethods {

    @Then("Tag value should contains {string}")
    public void tagValueShouldContains(String text) {
        Assert.assertTrue(driver.findElement(elementsMap.get("customTag")).getText().contains(text));
    }

}
