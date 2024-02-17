package DriverSession;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CucumberHook {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static List<String> pomName = new ArrayList<>();

    @Before
    public static void beforeScenario(Scenario scenario){
        pomName.add(FilenameUtils.getBaseName(scenario.getUri().toString()));
        driver.set(new ChromeDriver());
        driver.get().get("https://kontakt.az/");
        driver.get().manage().window().maximize();
    }

    @After
    public static void afterScenario(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()) {
            Thread.sleep(300);
            final byte[] screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.get().quit();
    }

}
