Feature: SmartGadgets
  Scenario Outline: Verify right opening products page ("<productSubCategory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    Then Product "<productSubCategory>" name should be displayed in new page

    Examples:
      | productCategory | productSubCategory |
      | Smart qadjetlər | Smart saatlar      |
      | Smart qadjetlər | Smart qolbaqlar    |
      | Smart qadjetlər | Qulaqlıqlar        |
      | Smart qadjetlər | Qol saatlar        |
      | Smart qadjetlər | Saat aksessuarları |
      | Smart qadjetlər | Nəqliyyat          |

  @ManufacturerFilter
  Scenario Outline: Check manufacturer filter ("<manufacturer>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User selects "<manufacturer>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    Then Products associated to selected "<model>" should be displayed

    Examples:
      | productCategory | productSubCategory | productType                  | manufacturer | model     |
      | Smart qadjetlər | Smart saatlar      |                              | Apple        | Apple     |
      | Smart qadjetlər | Smart saatlar      |                              | AMAZFIT      | AMAZFIT   |
      | Smart qadjetlər | Smart saatlar      |                              | Samsung      | Samsung   |
      | Smart qadjetlər | Smart qolbaqlar    |                              | Blackview    | Blackview |
      | Smart qadjetlər | Qulaqlıqlar        | Bluetooth simsiz qulaqlıqlar | AIWA         | AIWA      |

  @PriceFilter
  Scenario Outline: Check price filter ("<minPrice>" to "<maxPrice>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User inputs "<minPrice>" price in "minPriceInputField" and "<maxPrice>" price in "maxPriceInputField" from filter
    And User clicks "showAllProductBtn" button
    Then Products between "<minPrice>" price and "<maxPrice>" price should be displayed

    Examples:
      | productCategory | productSubCategory | productType                  | minPrice | maxPrice |
      | Smart qadjetlər | Smart saatlar      |                              | 500      | 1000     |
      | Smart qadjetlər | Smart saatlar      |                              | 1000     | 1500     |
      | Smart qadjetlər | Smart saatlar      |                              | 1500     | 2000     |
      | Smart qadjetlər | Smart qolbaqlar    |                              | 50       | 100      |
      | Smart qadjetlər | Smart qolbaqlar    |                              | 100      | 150      |
      | Smart qadjetlər | Qulaqlıqlar        | Bluetooth simsiz qulaqlıqlar | 200      | 500      |
      | Smart qadjetlər | Qulaqlıqlar        | Bluetooth simsiz qulaqlıqlar | 500      | 1000     |
@ColorFilter
  Scenario Outline: Check color filter ("<Color>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<Color>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    And User moves to another tab
    And User clicks "showAllProductSpecificationsButton" button
    Then Verify "<Color>" in "colorInfo" in product specifications

    Examples:
      | productCategory | productSubCategory | Color |
      | Smart qadjetlər | Smart saatlar      | BLACK |
      | Smart qadjetlər | Smart saatlar      | Blue  |

@NFCFilter
  Scenario Outline: Check NFC filter ("<NFC>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User clicks "expand" button at all filters
    And User selects "<NFC>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    And User moves to another tab
    And User clicks "showAllProductSpecificationsButton" button
    Then Verify "<NFC>" in "NFCInfo" in product specifications

    Examples:
      | productCategory | productSubCategory | NFC |
      | Smart qadjetlər | Smart saatlar      | Var |
      | Smart qadjetlər | Smart saatlar      | Yox |

@ScreenPropertiesFilter
  Scenario Outline: Check screen properties filter ("<screenProperties>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User clicks "expand" button at all filters
    And User clicks "showMoreButton" buttons
    And User selects "<screenProperties>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    And User moves to another tab
    And User clicks "showAllProductSpecificationsButton" button
    Then Verify "<screenProperties>" in "screenPropertiesInfo" in product specifications

    Examples:
      | productCategory | productSubCategory | screenProperties |
      | Smart qadjetlər | Smart saatlar      | 240 × 240        |
      | Smart qadjetlər | Smart saatlar      | 352 × 430        |

  @AddProduct
  Scenario Outline: Add product in basket ("<productSubCategory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User hovers to a product
    And User clicks "addToBasketBtn" button
    Then Selected products count should be displayed on "basketBtn"
    And User clicks "basketBtn" button
    Then Product should be displayed in "basketProducts"

    Examples:
      | productCategory | productSubCategory | productType                  |
      | Smart qadjetlər | Smart saatlar      |                              |
      | Smart qadjetlər | Smart qolbaqlar    |                              |
      | Smart qadjetlər | Qulaqlıqlar        | Bluetooth simsiz qulaqlıqlar |

  @RemoveProduct
  Scenario Outline: Remove all products from basket ("<productSubCategory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User hovers to a product
    And User clicks "addToBasketBtn" button
    And User clicks "basketBtn" button
    And User clicks "removeSelectedProductsBtn" button
    Then "Səbətinizdə məhsul yoxdur" message should be displayed in "emptyBasketSection"

    Examples:
      | productCategory | productSubCategory | productType                  |
      | Smart qadjetlər | Smart saatlar      |                              |
      | Smart qadjetlər | Smart qolbaqlar    |                              |
      | Smart qadjetlər | Qulaqlıqlar        | Bluetooth simsiz qulaqlıqlar |

  @ProductCount
  Scenario Outline: Check count of products after selecting filter ("<productSubCategory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User clicks "expand" button at all filters
    And User selects any filter ("filterCount")
    And User clicks "showAllProductBtn" button
    Then Products count should equals "filterCount"

    Examples:
      | productCategory | productSubCategory | productType                  |
      | Smart qadjetlər | Smart saatlar      |                              |
      | Smart qadjetlər | Smart qolbaqlar    |                              |
      | Smart qadjetlər | Qulaqlıqlar        | Bluetooth simsiz qulaqlıqlar |