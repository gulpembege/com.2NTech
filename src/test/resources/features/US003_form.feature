@US003 @smoke
Feature: 2NTECH basvuru formu gonderme

  Background:

    Given  Kullanici "formpageUrl" e gider

  @tc0301
  Scenario: Basvuru formu goruntuleme testi

    And Basvuru formunun goruntulendigini dogrular
    And KVKK metninin acilabildigini dogrular
    Then KVKK checkboxinin secili olmadigini dogrular

  @tc0302
  Scenario: Tam bilgilerle basarili gonderim yapabilme testi

    And Formun ilk sayfasini "Gulpembe Gemicioglu" "12031999" "44444444444" "05555555555" "gulpembe.gemicioglu@hotmail.com" "Lisans" bilgileriyle doldurur , cvsini ekler
    And Formun ikinci sayfasinda "Test Engineer" secimini yapar
    And  Formu gonderebildigini dogrular


