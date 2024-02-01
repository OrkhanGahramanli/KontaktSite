Feature: SmartPhonesAccessories
  Scenario Outline: Verify right opening products page
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    Then Product "<productSubCategory>" name should be displayed in new page

    Examples:
      | productCategory             | productSubCategory     |
      | Smartfonlar və aksessuarlar | Smartfonlar            |
      | Smartfonlar və aksessuarlar | Düyməli telefonlar     |
      | Smartfonlar və aksessuarlar | Stasionar telefonlar   |
      | Smartfonlar və aksessuarlar | Telefon aksessuarları  |
      | Smartfonlar və aksessuarlar | Qulaqlıqlar            |
      | Smartfonlar və aksessuarlar | Qulaqlıq aksessuarları |
@Case
  Scenario Outline: Check manufacturer filter
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<manufacturer>" from "manufacturers"
    Then Products associated to selected "<model>" should be displayed

    Examples:
      | productCategory             | productSubCategory | manufacturer | model  |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Apple        | iPhone |
      | Smartfonlar və aksessuarlar | Smartfonlar        | HUAWEI       | HUAWEI |