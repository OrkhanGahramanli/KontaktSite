package StepDefinitions;

import DriverSession.CucumberHook;
import enums.ExpectedConditionType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

        try{
            Class<?> generalClass = Class.forName("POM.GeneralPOM");
            Object generalObject = generalClass.getDeclaredConstructor().newInstance();
        }catch (Exception ignored){

        }
    }

    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }



    public WebDriver driver = CucumberHook.driver.get();
    WebDriverWait wait;

    protected void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    protected void clickAction(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click(element).build().perform();
    }

    protected void explicitWait(By locator , ExpectedConditionType expectedCondition , int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
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

    protected void explicitWait(WebElement element , ExpectedConditionType expectedCondition , int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (expectedCondition) {
            case VISIBLE: {
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            case INVISIBLE: {
                wait.until(ExpectedConditions.invisibilityOf(element));
                break;
            }
            case CLICKABLE: {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            }
            default:
                throw new IllegalArgumentException("Wrong expected condition");
        }
    }

    protected void explicitWaitList(List<WebElement> list , ExpectedConditionType expectedCondition , int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (expectedCondition) {
            case VISIBLE: {
                wait.until(ExpectedConditions.visibilityOfAllElements(list));
                break;
            }
            case INVISIBLE: {
                wait.until(ExpectedConditions.invisibilityOfAllElements(list));
                break;
            }
            default:
                throw new IllegalArgumentException("Wrong expected condition");
        }
    }

    protected void explicitWaitAttributeText(WebElement element , String attribute, String value, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    protected JavascriptExecutor getJsExecutor(){
        return (JavascriptExecutor)driver;
    }
    protected void dragAndDrop(WebElement start, WebElement end){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(start, end).build().perform();
    }

    protected void actionSendKeys(String value){
        Actions actions = new Actions(driver);
        actions.sendKeys(value).build().perform();
        }

    }

