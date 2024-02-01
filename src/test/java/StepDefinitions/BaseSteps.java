package StepDefinitions;

import enums.ExpectedConditionType;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static POM.ElementsMap.elementsMap;

public class BaseSteps extends BaseMethods {

    List<WebElement> list = new ArrayList<>();
    @AfterStep
    public void afterStep(){
        if (!list.isEmpty()) list.clear();
    }
@Given("User is in Home Page")
    public void userIsInHomePage(){
    
}

    @When("User selects {string} from {string}")
    public void userSelectsFrom(String text, String elements) {
        list = driver.findElements(elementsMap.get(elements));

    for (WebElement element : list){
            if (element.getText().equals(text)){
                try {
                    element.click();
                }catch (ElementNotInteractableException e){
                    getJsExecutor().executeScript("arguments[0].click();", element);
                }
                break;
            }
        }
    }
}
