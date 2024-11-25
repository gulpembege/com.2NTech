@US002 @smoke
Feature: 2NHABER web sitesi arama ve haber detayi goruntuleme

  Background:

    Given  Kullanici "homepageUrl" e gider


  @tc0201
  Scenario: Headerda search butonu gorunurlugu ve tiklanabilirligi testi

    And   Search butonu gorundugunu dogrular
    Then   Tiklanabilirligini dogrular

  @tc0202
  Scenario: Search butonuna bastiktan sonra input alaninin acilmasi testi

    And Search butonuna tiklar
    And Input alaninin acildigini dogrular
    Then  Submit butonu gorundugunu dogrular

  @tc0203
  Scenario: Input alanina yazilan metin ile ilgili sayfaya yonlendirme testi

    And Search butonuna tiklar
    And Input alanina "İstanbul" yazar
    And Acilan haberlerde 8 . habere tiklar
    Then  Haberin acildigini dogrular









