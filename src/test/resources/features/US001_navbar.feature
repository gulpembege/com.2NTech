@US001 @smoke
Feature:  2NHABER web sitesi navbar elemanlari kontrolu

 @tc0101
  Scenario: Navbar elementlerinin iliskili sayfaya yonlendirme testi

    Given  Kullanici "homepageUrl" e gider
    Then  Navbar elementlerine tiklar , iliskili sayfalarin acildigini dogrular


