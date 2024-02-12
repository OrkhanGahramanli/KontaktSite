Feature: SmartPhonesAccessories
  Scenario Outline: Verify right opening products page ("<productSubCategory>")
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
@ManufacturerFilter
  Scenario Outline: Check manufacturer filter ("<manufacturer>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<manufacturer>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    Then Products associated to selected "<model>" should be displayed

    Examples:
      | productCategory             | productSubCategory | manufacturer | model    |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Apple        | iPhone   |
      | Smartfonlar və aksessuarlar | Smartfonlar        | HUAWEI       | HUAWEI   |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Motorola     | Motorola |
      | Smartfonlar və aksessuarlar | Düyməli telefonlar | Nokia        | Nokia    |

  @PriceFilter
  Scenario Outline: Check price filter ("<minPrice>" to "<maxPrice>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User inputs "<minPrice>" price in "minPriceInputField" and "<maxPrice>" price in "maxPriceInputField" from filter
    And User clicks "showAllProductBtn" button
    Then Products between "<minPrice>" price and "<maxPrice>" price should be displayed

    Examples:
      | productCategory             | productSubCategory   | minPrice | maxPrice |
      | Smartfonlar və aksessuarlar | Smartfonlar          | 500      | 1500     |
      | Smartfonlar və aksessuarlar | Smartfonlar          | 1500     | 2500     |
      | Smartfonlar və aksessuarlar | Smartfonlar          | 2500     | 3500     |
      | Smartfonlar və aksessuarlar | Stasionar telefonlar | 50       | 100      |
      | Smartfonlar və aksessuarlar | Stasionar telefonlar | 100      | 150      |

  @SerialNumFilter
  Scenario Outline: Check product serial name filter ("<productSerialName>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User clicks "showMoreButton" buttons
    And User selects "<productSerialName>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    Then Products associated to selected "<productSerialName>" should be displayed

    Examples:
      | productCategory             | productSubCategory | productSerialName        |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Blackview A100           |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Samsung Galaxy S23 Ultra |
      | Smartfonlar və aksessuarlar | Smartfonlar        | iPhone 14 Plus           |

  @OperationSystemFilter
  Scenario Outline: Check product operation system filter ("<productOperationSystem>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productOperationSystem>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    And User moves to another tab
    And User clicks "showAllProductSpecificationsButton" button
    Then Verify "<productOperationSystem>" in "operationSystemInfo" in product specifications

    Examples:
      | productCategory             | productSubCategory | productOperationSystem |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Android                |
      | Smartfonlar və aksessuarlar | Smartfonlar        | iOS                    |

  @SimCardFilter
  Scenario Outline: Check sim card filter ("<simCardCount>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<simCardCount>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    Then Verify "<simCardCount>" in "simCardCount" in product specifications

    Examples:
      | productCategory             | productSubCategory | simCardCount |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 1            |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 2            |

  @RAMFilter
  Scenario Outline: Check RAM filter ("<RAM>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User clicks "expand" button at all filters
    And User selects "<RAM>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    Then Product "productRAMInfo" which contains "<RAM>" should be displayed
    Then Verify "<RAM>" in "RAMsize" in product specifications

    Examples:
      | productCategory             | productSubCategory | RAM  |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 2 GB |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 4 GB |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 8 GB |

  @MemoryFilter
  Scenario Outline: Check memory filter ("<Memory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User clicks "expand" button at all filters
    And User selects "<Memory>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    Then Product "productMemoryInfo" which contains "<Memory>" should be displayed
    Then Verify "<Memory>" in "memorySize" in product specifications

    Examples:
      | productCategory             | productSubCategory | Memory |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 64 GB   |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 128 GB |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 256 GB |

  @ScreenFilter
  Scenario Outline: Check screen filter ("<screen>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User clicks "expand" button at all filters
    And User selects "<screen>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    Then Product "productScreenInfo" which contains "<screen>" should be displayed
    Then Verify "<screen>" in "screenSize" in product specifications

    Examples:
      | productCategory             | productSubCategory | screen |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 6.1    |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 6.5    |
      | Smartfonlar və aksessuarlar | Smartfonlar        | 6.7    |
      | Smartfonlar və aksessuarlar | Düyməli telefonlar | 2.8    |

  @NFCFilter
  Scenario Outline: Check screen filter ("<NFC>")
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
      | productCategory             | productSubCategory | NFC |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Var |
      | Smartfonlar və aksessuarlar | Smartfonlar        | Yox |

  @AddProduct
  Scenario Outline: Add product in basket ("<productSubCategory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User hovers to a product
    And User clicks "addToBasketBtn" buttons
    Then Selected products count should be displayed on "basketBtn"
    And User clicks "basketBtn" button
    Then Product should be displayed in "basketProducts"

    Examples:
      | productCategory             | productSubCategory   |
      | Smartfonlar və aksessuarlar | Smartfonlar          |
      | Smartfonlar və aksessuarlar | Düyməli telefonlar   |
      | Smartfonlar və aksessuarlar | Stasionar telefonlar |

  @RemoveProduct
  Scenario Outline: Remove all products from basket ("<productSubCategory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User hovers to a product
    And User clicks "addToBasketBtn" buttons
    And User clicks "basketBtn" button
    And User clicks "removeSelectedProductsBtn" button
    Then "Səbətinizdə məhsul yoxdur" message should be displayed in "emptyBasketSection"

    Examples:
      | productCategory             | productSubCategory   |
      | Smartfonlar və aksessuarlar | Smartfonlar          |
      | Smartfonlar və aksessuarlar | Düyməli telefonlar   |
      | Smartfonlar və aksessuarlar | Stasionar telefonlar |

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
      | productCategory             | productSubCategory   |
      | Smartfonlar və aksessuarlar | Smartfonlar          |
      | Smartfonlar və aksessuarlar | Düyməli telefonlar   |
      | Smartfonlar və aksessuarlar | Stasionar telefonlar |

  @ProductCountIncrease
  Scenario Outline: Increase count of products in basket ("<productSubCategory>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User hovers to a product
    And User clicks "addToBasketBtn" buttons
    And User clicks "basketBtn" button
    And User clicks "productIncreaseBtn" buttons
    Then Each "productCount" should be 2

    Examples:
      | productCategory             | productSubCategory |
      | Smartfonlar və aksessuarlar | Smartfonlar        |