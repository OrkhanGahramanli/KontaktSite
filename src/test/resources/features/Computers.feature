Feature: Computers

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
      | productCategory           | productSubCategory | productType     | manufacturer | model  |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Sistem blokları | Hp           | Hp     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monitorlar      | Dell         | Dell   |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monobloklar     | Lenovo       | Lenovo |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Notbuklar       | Asus         | Asus   |

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
      | productCategory           | productSubCategory | productType     | minPrice | maxPrice |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Sistem blokları | 2000     | 3000     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monitorlar      | 1000     | 2000     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monobloklar     | 5000     | 6000     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Notbuklar       | 3000     | 4000     |

  @ScreenFilter
  Scenario Outline: Check screen filter ("<screen>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User clicks "expand" button at all filters
    And User clicks "showMoreButton" buttons
    And User selects "<screen>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    Then Verify "<screen>" in "screenDiagonal" in product specifications

    Examples:
      | productCategory           | productSubCategory | productType | screen |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Notbuklar   | 13.3   |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Notbuklar   | 14.2   |

  @RAMFilter
  Scenario Outline: Check RAM filter ("<RAM>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User clicks "expand" button at all filters
    And User selects "<RAM>" from "checkboxFilter"
    And User clicks "showAllProductBtn" button
    And User selects any product
    Then Verify "<RAM>" in "compRAMInfo" in product specifications

    Examples:
      | productCategory           | productSubCategory | productType     | RAM   |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Sistem blokları | 8 GB  |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Sistem blokları | 16 GB |

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
      | productCategory           | productSubCategory | productType     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Sistem blokları |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monitorlar      |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monobloklar     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Notbuklar       |

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
      | productCategory           | productSubCategory | productType     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Sistem blokları |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monitorlar      |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monobloklar     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Notbuklar       |

  @ProductCount
  Scenario Outline: Check count of products after selecting filter ("<productType>")
    Given User is in Home Page
    When User selects "<productCategory>" from "productCategoryList"
    And User selects "<productSubCategory>" from "productSubCategoryList"
    And User selects "<productType>" from "productTypes"
    And User clicks "expand" button at all filters
    And User selects any filter ("filterCount")
    And User clicks "showAllProductBtn" button
    Then Products count should equals "filterCount"

    Examples:
      | productCategory           | productSubCategory | productType     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Sistem blokları |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monitorlar      |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Monobloklar     |
      | Notbuklar, PK, planşetlər | Kompüterlər        | Notbuklar       |