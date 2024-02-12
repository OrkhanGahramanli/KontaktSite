package POM;

import StepDefinitions.BaseMethods;
import org.openqa.selenium.By;

import static POM.ElementsMap.elementsMap;

public class GeneralPOM extends BaseMethods {

    {
        elementsMap.put("catalog", By.className("topMenu__icon"));
        elementsMap.put("productCategoryList", By.className("catalogMenu__link"));
        elementsMap.put("productSubCategoryList", By.className("category-list"));
        elementsMap.put("productSubCategoryName", By.xpath("//*[@class='catalog__item catalog__item--1']/h1"));
        elementsMap.put("productName", By.className("prodItem__title"));
        elementsMap.put("minPriceInputField", By.xpath("//*[@data-role='from-label']"));
        elementsMap.put("maxPriceInputField", By.xpath("//*[@data-role='to-label']"));
        elementsMap.put("checkboxFilter", By.className("title"));
        elementsMap.put("productsPrices", By.xpath("//*[@class='prodItem__prices prodItem__prices--active']/strong/b"));
        elementsMap.put("showMoreButton", By.xpath("//*[@data-bind='text: showMoreLabel']"));
        elementsMap.put("customTag", By.xpath("//*[@class='customTag'][1]/span"));
        elementsMap.put("productLink", By.cssSelector("div.prodItem"));
        elementsMap.put("expand", By.className("filter-container__activated"));
        elementsMap.put("showAllProductSpecificationsButton", By.xpath(" //a/strong[1]"));
        elementsMap.put("NFCInfo", By.xpath("//div[1]/div[15]/div[2]"));
        elementsMap.put("addToBasketBtn", By.cssSelector(".prodItem__mmaddcard.tocart"));
        elementsMap.put("basketBtn", By.xpath("//*[@data-block='minicart']/a"));
        elementsMap.put("basketProducts", By.cssSelector(".form.form-cart"));
        elementsMap.put("ProductCountInBasketIcon", By.xpath("//*[@data-items-count='value']"));
        elementsMap.put("removeSelectedProductsBtn", By.id("remove-selected"));
        elementsMap.put("emptyBasketSection", By.className("cartEmpty__h2"));
        elementsMap.put("productTypes", By.className("category-list"));
        elementsMap.put("filterCount", By.xpath("//label/span[@class='count']"));
        elementsMap.put("showAllProductBtn", By.className("contentosResult"));
    }
}
