package StepDefinitions;

import DriverSession.CucumberHook;
import org.openqa.selenium.WebDriver;

import static DriverSession.CucumberHook.pomName;

public abstract class BaseMethods {

    static {
        try {
          Class<?> clazz = Class.forName("POM." + pomName + "POM");
          Object o = clazz.getDeclaredConstructor().newInstance();
        }catch (Exception ignored){

        }
    }
    public WebDriver driver = CucumberHook.driver.get();
}
