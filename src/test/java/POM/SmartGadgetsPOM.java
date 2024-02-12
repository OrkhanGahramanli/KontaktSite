package POM;

import StepDefinitions.BaseMethods;
import org.openqa.selenium.By;

import static POM.ElementsMap.elementsMap;

public class SmartGadgetsPOM extends BaseMethods {

    {
        elementsMap.put("colorInfo", By.xpath("//div[2]/div[14]/div[2]"));
        elementsMap.put("screenPropertiesInfo", By.xpath("//div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]"));
    }
}
