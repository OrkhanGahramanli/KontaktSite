package StepDefinitions;

import DriverSession.CucumberHook;
import enums.ExpectedConditionType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static DriverSession.CucumberHook.pomName;

public abstract class BaseMethods {

    static {
        try {
            Class<?> clazz = Class.forName("POM." + pomName + "POM");
            Object o = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ignored) {

        }
    }

    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }



    public WebDriver driver = CucumberHook.driver.get();

    protected void explicitWait(By locator, ExpectedConditionType expectedCondition, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (expectedCondition) {
            case VISIBLE: {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            }
            case PRESENCE: {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            }
            case INVISIBLE: {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                break;
            }
            case CLICKABLE: {
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            }
            default:
                throw new IllegalArgumentException("Wrong expected condition");
        }


    }
}
