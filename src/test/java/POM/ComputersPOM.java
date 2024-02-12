package POM;

import StepDefinitions.BaseMethods;
import org.openqa.selenium.By;

import static POM.ElementsMap.elementsMap;

public class ComputersPOM extends BaseMethods {

    {
        elementsMap.put("screenDiagonal", By.xpath("//div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]"));
        elementsMap.put("compRAMInfo", By.xpath("//div[1]/div[5]/div[2]"));
    }
}
