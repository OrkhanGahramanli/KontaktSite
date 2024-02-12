package POM;

import StepDefinitions.BaseMethods;
import org.openqa.selenium.By;

import static POM.ElementsMap.elementsMap;

public class SmartphonesPOM extends BaseMethods {

    {
        elementsMap.put("simCardCount", By.xpath("//*[1]/div/div/div[1]/div[7]/div[2]"));
        elementsMap.put("RAMfilter",
                By.xpath("//*[@data-bind=\"scope: 'kh_operativ_yaddaFilter'\"]/ol[@class='items']/li/span/label/span[@class='title']"));
        elementsMap.put("productRAMInfo", By.xpath("//span[2]/em"));
        elementsMap.put("RAMsize", By.xpath("//div[2]/div[1]/div/div/div[1]/div[3]/div[2]"));
        elementsMap.put("productMemoryInfo", By.xpath("//span[3]/em"));
        elementsMap.put("memorySize", By.xpath("//div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]"));
        elementsMap.put("productScreenInfo", By.xpath("//span[1]/em"));
        elementsMap.put("screenSize", By.xpath("//div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[2]"));
        elementsMap.put("operationSystemInfo", By.xpath("//div[1]/div[11]/div[2]"));
    }
}