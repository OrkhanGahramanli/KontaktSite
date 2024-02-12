
import POM.LoginPOM;
import StepDefinitions.BaseMethods;
import enums.ExpectedConditionType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import javax.accessibility.AccessibleState;

import static javax.accessibility.AccessibleState.VISIBLE;

public class LoginStepDefinitions<JavaScriptexecutor> extends BaseMethods {


    LoginPOM loginPom = new LoginPOM();




    @Given("User is in main page")
    public void userIsInMainPage()  throws InterruptedException{
        Thread.sleep(1000);
        driver.get("https://kontakt.az/");

    }

    @When("Decline discount alert")
    public void declineDiscountAlert() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[class='action secondary'] span")).click();
    }

    @And("Click Daxil Ol Btn")
    public void clickDaxilOlBtn() {

        By locator = By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div[2]/div/div[1]/a/span[1]");
        explicitWait(locator, VISIBLE, 40);
        getElement(locator).click();

       
    }

    private void explicitWait(By daxilOlBtn, AccessibleState visible, int i) {
    }

    @And("Fill the username btn with dynamic string {}")
    public void fillTheUsernameBtn(String username) throws InterruptedException{
     Thread.sleep(2000);
     explicitWait(loginPom.getEmailField(), ExpectedConditionType.PRESENCE, 40);
     driver.findElement(loginPom.getEmailField()).sendKeys(username);
     driver.findElement(loginPom.getEmailField()).click();
    }

    @And("Fill the password btn with dynamic string {}")
    public void fillThePasswordBtn(String password){
        explicitWait(loginPom.getPasswordField(), ExpectedConditionType.PRESENCE, 10);
//        driver.switchTo();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//         js.executeScript("window.scrollBy(0,500)", "");
        //WebElement.sendKeys(Keys.DOWN);
       driver.findElement(loginPom.getPasswordField()).sendKeys(password);
    }

    @And("Click submit btn")
    public void clickSubmitBtn()throws InterruptedException{
        explicitWait((loginPom.getSubmitBtn()), VISIBLE, 20);
        driver.findElement(loginPom.getSubmitBtn()).click();
//        Actions act = new Actions(driver);
//        WebElement userlogo = driver.findElement(loginPom.getUserLogo());
//        act.doubleClick(userlogo).perform();
        Thread.sleep(6000);

    }

    @Then("User must be login")
    public void userMustBeLogin() throws InterruptedException {

        explicitWait(loginPom.getUserLogo(), ExpectedConditionType.PRESENCE, 60);
        driver.findElement(loginPom.getUserLogo()).click();
        Thread.sleep(10000);
        explicitWait(loginPom.getUsername(), VISIBLE, 90);
        Assert.assertTrue(driver.findElement(loginPom.getUsername()).isDisplayed());

    }

    @And("Click Register Btn")
    public void clickRegisterBtn() throws InterruptedException {

        Thread.sleep(5000);

//        Actions action = new Actions(driver);
//        action.moveToElement((WebElement) loginPom.getRegisterBtn()).click().perform();

//        WebElement html = driver.findElement(By.tagName("html"));
//        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
//        html.sendKeys(Keys.chord(Keys.CONTROL, "60"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.body.style.zoom='50%'");
        Thread.sleep(4000);
//        Actions action = new Actions(driver);
//         action.moveToElement((WebElement) loginPom.getRegisterBtn()).click().perform();
        driver.findElement(loginPom.getRegisterBtn()).click();
    }


//    @And("Open new tab to create email")
//    public void openNewTabToCreateEmail() throws InterruptedException {
//        Set<String> handles = driver.getWindowHandles();
//        ((JavascriptExecutor) driver).executeScript("window.open('https://temp-mail.org/en/')");
//        Thread.sleep(7000);
//
////        driver.findElement(By.xpath("//xpath_of_email_element")).click();
//        Thread.sleep(5000);
//        Actions act = new Actions(driver);
//
////        driver.findElement(By.xpath("(//input[@id='mail'])[1]")).getAttribute("innerText");
//
//        //normal click ile ise yaramir
////        driver.findElement(By.id("click-to-copy")).click();
//
//
//        //action ile ise yaramir
////WebElement btnElement = driver.findElement(By.id("click-to-copy"));
////act.moveToElement(btnElement).click().perform();
//
//// get text ile de her cure element find ile yoxladim alinmir.
//
////String theEmail = driver.findElement(By.xpath("/html/body/div/div[3]/section[1]/div/div[2]/div[1]/div[1]/button/p")).getText();





//        driver.switchTo().window(tabs.get(0));
//        Thread.sleep(4000);
//        explicitWait(loginPom.getRegisterEmail(), ExpectedConditionType.PRESENCE, 30);
//        driver.findElement(By.xpath("(//input[@id='email_address'])[1]")).sendKeys(text);
//
//



    @Then("Click the Registerr Btn")
    public void clickTheRegisterBtn() {
        explicitWait(loginPom.getRegisterSubmit(), ExpectedConditionType.PRESENCE, 50);
        driver.findElement(loginPom.getRegisterSubmit()).click();
    }

    @Then("User shouldn't be registered")
    public void userShouldnTBeRegistered() {
        explicitWait(loginPom.getRegisterSubmit(), ExpectedConditionType.PRESENCE, 50);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='regAutoriz__span1'])[1]")).isDisplayed());


                ;
    }

    @And("Fill the firstName Btn with dynamic string {}")
    public void fillTheFirstNameBtn(String username) {
        explicitWait(loginPom.getRegisterName(), ExpectedConditionType.PRESENCE, 40);
        driver.findElement(loginPom.getRegisterName()).sendKeys(username);
    }

    @And("Fill the secondName Btn with dynamic string {}")
    public void fillTheSecondNameBtn(String secondname) {
        explicitWait(loginPom.getRegisterSurname(), ExpectedConditionType.PRESENCE, 40);
        driver.findElement(loginPom.getRegisterSurname()).sendKeys(secondname);
    }

    @And("Fill the email with dynamic string{}")
    public void fillTheEmail(String email) {
        explicitWait((loginPom.getRegisterEmail()), ExpectedConditionType.PRESENCE, 40 );
        driver.findElement(loginPom.getRegisterEmail()).sendKeys(email);
    }

    @And("Fill the paswords with dynamic string{}")
    public void fillThePaswords(String password) {
        explicitWait((loginPom.getRegisterPassword()), ExpectedConditionType.PRESENCE, 40 );
        driver.findElement(loginPom.getRegisterPassword()).sendKeys(password);
    }

    @Then("User must not be login")
    public void userMustNotBeLogin() throws InterruptedException{
        explicitWait((loginPom.getLoginErrorText()), ExpectedConditionType.PRESENCE,  30) ;
        Assert.assertTrue(driver.findElement(loginPom.getLoginErrorText()).isDisplayed());



    }
}


