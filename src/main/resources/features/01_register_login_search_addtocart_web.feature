Feature: 01 Register Login Search Cart Web

  @test
  Scenario: (+) User register in Bukalapak
    Given user opens the Bukalapak URL in browser
    When user click button daftar on home page Bukalapak
    And user input phone number "085157004701"
    And user click button daftar
    And user click button ya kirim kode
    Then user click icon close


  @test
  Scenario: (+) User success login in Bukalapak
    When user click button login from register page Bukalapak
    And user fill username Bukalapak "tukustyle"
    And user fill password Bukalapak "yogi123456"
    Then user click button login Bukalapak

  @test
  Scenario: (+) User success search product
    When user fill product name on field search "baseus"
    And user click icon search

  @test
  Scenario: (+) User success add product to cart
    And user click item product
    Then user add product to cart

