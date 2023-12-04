Feature: websiteGlossary

@WsTnsGloData
Scenario Outline: user should able to import glossary with all words verified
Given User fills the Login Page "<emailid>" and "<otp>"
When user should be able to select "<language>" in "<glossary>" file in "<team>" Team
And user should be able to import a glossary "<file>" with all glossary words should be "verified"
Then he should be to verify his all glossary words should be "verified"
Examples:
|emailid                         |otp      |team                         |glossary               |language|file  |
|automationtesting281@gmail.com  |674592   |Selenium automation testing  |teamMemberTestGlossary |Telugu  |site6 |

@WsTnsGloData
Scenario Outline: user should able to import glossary with all words unverified
  Given User fills the Login Page "<emailid>" and "<otp>"
  When user should be able to select "<language>" in "<glossary>" file in "<team>" Team
  And user should be able to import a glossary "<file>" with all glossary words should be "unverified"
  Then he should be to verify his all glossary words should be "unverified"
  Examples:
    |emailid                         |otp      |team                         |glossary              |language|file  |
    |automationtesting281@gmail.com  |674592   |Selenium automation testing  |teamMemberTestGlossary|Telugu  |site6 |

@WsTnsGloData
Scenario Outline: user should able to Edit a glossary words
Given User fills the Login Page "<emailid>" and "<otp>"
When user should be able to select "<language>" in "<glossary>" file in "<team>" Team
And  user should be able to edit a "<source word>" with "<updated word>" glossary file
Then he should get his updated "<target word>" in View tab
Examples:
|emailid                         |otp      |team                         |glossary              |language |source word        |updated word                  |target word                                       |
|automationtesting281@gmail.com  |674592   |Selenium automation testing  |teamMemberTestGlossary|Telugu   |Proudly powered by |విత్ర వెబ్సైటు త్రన్స్లతిఒన్ టెస్టింగ్  |Proudly powered by,విత్ర వెబ్సైటు త్రన్స్లతిఒన్ టెస్టింగ్  |

@WsTnsGloData
Scenario Outline: user should able to make a word verified and set glossary filter
Given User fills the Login Page "<emailid>" and "<otp>"
When user should be able to select "<language>" in "<glossary>" file in "<team>" Team
And user should be able to make a glossary "<word>" verified
Then user should be able to see his verified "<word>" after making a glossary filter "Verified"
Examples:
|emailid                         |otp      |team                         |glossary              |language|word              |
|automationtesting281@gmail.com  |674592   |Selenium automation testing  |teamMemberTestGlossary|Telugu  |Proudly powered by|

  @WsTnsGloData
  Scenario Outline: user should able to Export glossary with Verified and UnVerified
    Given User fills the Login Page "<emailid>" and "<otp>"
    When user should be able to select "<language>" in "<glossary>" file in "<team>" Team
    Then user should be able to export a glossary file with "verified" and "Unverified"
    Examples:
      |emailid                         |otp      |team                         |glossary              |language |
      |automationtesting281@gmail.com  |674592   |Selenium automation testing  |teamMemberTestGlossary|Telugu   |
