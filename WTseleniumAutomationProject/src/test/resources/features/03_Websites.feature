Feature: Websites
#
#  @WsTnsData
#  Scenario Outline: user should be able to create a website without setup integration
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When User should be able to create a "<website>" with "<websiteTechnology>" and "<websiteType>" in "<teamName>" Team
#    And  he should be able to verify created "<website>" in website's Tab
#    And  he should able to open newly created "<website>"
#    And  Verify OnDemand TT should be "Enabled" and website type "<Webtype>" and websitesName should be "<website>"
#    Then verify Domain Name should be "No Domain" and source language Name should be "No Language" for the current "<website>" in Website's Tab
#    Examples:
#      |emailid                |otp      |teamName                     |website                  |websiteTechnology|websiteType|Webtype  |
#      |hemadrir556@gmail.com  |674592   |Selenium automation testing  | SampleSeleniumWebsite   |React JS         |Ecommerce  |ECOMMERCE|
#
#  @WsTnsData
#  Scenario Outline: user should be able to generate site map
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When User should be able to create a "<website>" with "<websiteTechnology>" and "<websiteType>" in "<teamName>" Team
#    And  he should be able to verify created "<website>" in website's Tab
#    And  he should able to generate Site map "<url>" in "<website>"
#    Then Verify site map generated success notification
#    Examples:
#      |emailid               |otp      |teamName                     |website                  |websiteTechnology|websiteType|url                             |
#      |hemadrir556@gmail.com |674592   |Selenium automation testing  | sitemapGenerateWebsite  |Others           |Others     |https://site2.reachabilty.com/  |
#
#  @WsTnsData
#  Scenario Outline: user should be able to create a website and generate a vitra snippet code
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When User should be able to create a "<website>" with "<websiteTechnology>" and "<websiteType>" in "<teamName>" Team
#    And  he should be able to verify created "<website>" in website's Tab
#    And   he should able set "<source>" language and "<target>" language and glossary "<gName>" for the current "<website>"
#    And   he should able to fill set Integration Configuration details
#          | Domain url                                | Directories  | OnDemand translationLimit   | OnDemand translation |Show Flag|Google Analytics|
#          | https://site2.reachabilty.com/            | Enabled      | Enabled                     | Enabled              |Enabled  |Disabled        |
#    And   he should be get Vitra Snippet code
#    Then  he should able to verify his Domain "<url>" and "<source>" language in Websites' tab for current "<website>"
#    Examples:
#      |emailid                |otp      |teamName                    |url                            |website             |websiteTechnology|websiteType   |source   |target    |gName                |
#      |hemadrir556@gmail.com  |674592   |Selenium automation testing |https://site2.reachabilty.com/ | automationWebsite  |Others           |Others        |English  |తెలుగు     |onFlySampleGlossary |

#  @WsTnsData
#  Scenario Outline: user should be able to create a website and generate a vitra snippet cod
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    And   he should able set "<source>" language and "<target>" language and glossary "<gName>" for the current "<website>"
#    Examples:
#      |emailid                |otp      |teamName                    |url                            |website             |websiteTechnology|websiteType   |source   |target    |gName                   |
#      |automationtesting281@gmail.com  |674592   |Selenium automation testing |https://site6.reachabilty.com/ | automationWebsite  |Others           |Others        |English  |తెలుగు     |Automation TestGlossary |









  @WsTnsData
  Scenario Outline: TeamMember should be able to create a website and generate a vitra snippet code
    Given User fills the Login Page "<emailid>" and "<otp>"
    When User should be able to create a "<website>" with "<websiteTechnology>" and "<websiteType>" in "<teamName>" Team
    And  he should be able to verify created "<website>" in website's Tab
    And   he should able set "<source>" language and "<target>" language and glossary "<gName>" for the current "<website>"
    And   he should able to fill set Integration Configuration details
      | Domain url                                | Directories  | OnDemand translationLimit   | OnDemand translation |Show Flag|Google Analytics|
      | https://site6.reachabilty.com/            | Enabled      | Enabled                     | Enabled              |Enabled  |Disabled        |
    And   he should be get Vitra Snippet code
    Then  he should able to verify his Domain "<url>" and "<source>" language in Websites' tab for current "<website>"
    Examples:
      |emailid                         |otp      |teamName                    |url                            |website                     |websiteTechnology|websiteType   |source   |target    |gName                   |
      |automationtesting281@gmail.com  |674592   |Selenium automation testing |https://site6.reachabilty.com/ |TeamMemberAutomationWebsite |Others           |Others        |English  |తెలుగు     |teamMemberTestGlossary |


  @WsTnsData
  Scenario Outline: user should be able to Delete a website
    Given User fills the Login Page "<emailid>" and "<otp>"
    When User should be able to create a "<website>" with "<websiteTechnology>" and "<websiteType>" in "<teamName>" Team
    And  he should be able to verify created "<website>" in website's Tab
    And  he should able to open newly created "<website>"
    Then he should be able to delete the website
    Examples:
      |emailid                |otp      |teamName                     |website                  |websiteTechnology|websiteType|
      |hemadrir556@gmail.com  |674592   |Selenium automation testing  | DeleteSeleniumWebsite   |React JS         |Ecommerce  |

  @WsSnippet
  Scenario Outline: user should be able to past snippet code in wp-code site2
    Given User fills the wp-admin Login Page "<username>" and "<password>"
    When  User should be able open snippet codes
    Then  he should be able to add snippet code with "<title>"
    Examples:
      |username   |password      |title                        |
      |admin      |VitraWTPass   |Selenium automation testing  |

# @Website
#  Scenario Outline: user should be able to get vitra language switch drop down
#    Given User opens site2 "<Url>"
#    When  User should be able to verify vitra language switch drop down
#    Then  he should be able to get his website with "<target>" language
#    Examples:
#      |Url                                 |target    |
#      |https://site6.reachabilty.com/      |తెలుగు    |



