Feature: V2Glossary

  @WsTnsGlossary
  Scenario Outline: user should be able to create a new glossary and import&export should be disable
    Given User fills the Login Page "<emailid>" and "<otp>"
    When User should be to verify default glossary created with "<teamname>" name
    And user should be able create a new "<glossary>" with "<description>"
    And  user should able to open newly created "<glossary>"
    Then "Import Files" and "Export CSV" and lamguages should be disabled
    Examples:
      |emailid                |otp      |teamname                     |glossary               |description    |
      |hemadrir556@gmail.com  |674592   |Selenium automation testing  |Automation TestGlossary|testGlossary   |

  @WsTnsGlossary
  Scenario Outline: user should be able to edit glossary file name
    Given User fills the Login Page "<emailid>" and "<otp>"
    When user should be able create a new "<glossary>" with "<description>" in "<teamname>" Team
    And  user should able to Edit "<glossary>" and update glossary "<name>"
    Then he should be able to verify edited glossary file "<name>" in glossary's Tab
    Examples:
      |emailid                |otp      |teamname                    |glossary           |description            |name                         |
      |hemadrir556@gmail.com  |674592   |Selenium automation testing |Sample TestGlossary|testGlossary automation|Selenium Sample test glossary|

 @WsTnsGlossary
  Scenario Outline: user should be able to Delete a glossary file
    Given User fills the Login Page "<emailid>" and "<otp>"
    When user should be able to delete a "<glossary>" file in "<teamname>" Team
    Then deleted "<glossary>" file should not exits in glossary's Tab
    Examples:
      |emailid                |otp      |teamname                     |glossary                     |
      |hemadrir556@gmail.com  |674592   |Selenium automation testing  |Selenium Sample test glossary|

  @WsTnsGlossary
  Scenario Outline: user should be able to create a glossary on website setup
    Given User fills the Login Page "<emailid>" and "<otp>"
    When User should be able to create a "<website>" with "<websiteTechnology>" and "<websiteType>" in "<teamName>" Team
    And  he should be able to verify created "<website>" in website's Tab
    And   he should able set "<source>" language and "<target>" language for the current "<website>"
    And   he should able to create a glossary and select created glossary file in website setup
      |GlossaryName                   |Glossary Description             |
      |onFlySampleGlossary            |test glossary onFly in websites  |
    Examples:
      |emailid                |otp      |teamName                     |website                 |websiteTechnology|websiteType   |source   |target     |
      |hemadrir556@gmail.com  |674592   |Selenium automation testing  | glossaryCreateWebsite  |Others           |Others        |English  |हिन्दी       |

  @WsTnsGlossary
  Scenario Outline: Team Member should be able to create a new glossary
    Given User fills the Login Page "<emailid>" and "<otp>"
    When user should be able create a new "<glossary>" with "<description>" in Owner "<Team>"
    Then "<glossary>" created by should be team member name "Alexander Kelly"
    Examples:
      |emailid                         |otp      |Team                         |glossary               |description    |
      |automationtesting281@gmail.com  |674592   |Selenium automation testing  |teamMemberTestGlossary|testGlossary   |


  @WsTnsGlossary
  Scenario Outline: Team Member should be able to Delete a glossary file
    Given User fills the Login Page "<emailid>" and "<otp>"
    When user should be able to delete a "<glossary>" file in "<teamname>" Team
    Then deleted "<glossary>" file should not exits in glossary's Tab
    Examples:
      |emailid                         |otp      |teamname                     |glossary                     |
      |automationtesting281@gmail.com  |674592   |Selenium automation testing  |Selenium Sample test glossary|


