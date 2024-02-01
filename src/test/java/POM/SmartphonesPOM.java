package POM;

import StepDefinitions.BaseMethods;
import org.openqa.selenium.By;

import static POM.ElementsMap.elementsMap;

public class SmartphonesPOM extends BaseMethods {

    {
        elementsMap.put("catalog", By.className("topMenu__icon"));
        elementsMap.put("productCategoryList", By.className("catalogMenu__link"));
        elementsMap.put("productSubCategoryList", By.className("category-list"));
        elementsMap.put("productSubCategoryName", By.xpath("//*[@class='catalog__item catalog__item--1']/h1"));
        elementsMap.put("manufacturers", By.cssSelector("span.title"));
        elementsMap.put("productName", By.className("prodItem__title"));
    }
}
