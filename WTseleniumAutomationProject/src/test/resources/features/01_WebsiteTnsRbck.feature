#Feature: WebsiteTnsRbck
#
##  scenario commented bcz google sign was not working in automation but manualy it's working fine
##  @WsTnsData
##  Scenario Outline: user should be able to signup with google account
##    Given User opens the login page and signupwithgoogle
##    When User enters "<gmail>" id and "<password>"
##    Then User should be able to see website translation home page
##    Examples:
##      |gmail                  |password       |
###      |hemadrir556@gmail.com  |Hemadri@9966    |
##  @WsTnsData
##  Scenario Outline: user should not allow to delete or edit default Team default glossary
##    Given User fills the Login Page "<emailid>" and "<otp>"
##    When User should be verify his default "<team>"
##    Then he should not be able to edit or delete for default glossary
##    Examples:
##      |emailid              |otp      |team                     |mailid                              |invited by         |members                        |
##      |hemadrir556@gmail.com|674592   |Selenium automation testing  |user1@gmail.com,user2@gmail.com     | hemadri.t  vitra  |user1@gmail.com,user2@gmail.com|
#
#  @WsTnsRbckData
#  Scenario Outline: user should be able to create a new team and inviting a new member
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When User should be create a "<team>" and if it exits he should able to open
#    And user should be able to verify his "<team>" in TeamMembers and glossary tabs
#    And  user should be able to verify his own "<emailid>" in teamMembers and invited by should be "<invited by>"
#    And user should be able to invite a newMembers "<mailid>" and able verify invited members mails and "<invited by>" in teammembers dash board
#    Then invited "<members>" name should be "Not Recieved" in TeamMembers Tab
#    Examples:
#      |emailid              |otp      |team                         |mailid                              |invited by      |members                        |
#      |hemadrir556@gmail.com|674592   |Selenium automation testing  |user1@gmail.com,user2@gmail.com     | Kamala  Harris |user1@gmail.com,user2@gmail.com|
#
#
#  @WsTnsRbckData
#  Scenario Outline: user should be able to Restore members
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When In "<Team>" team user should be able to restore "<members>" in teammembers dash board
#    And Restored "<members>" names should not be "Not Recieved"
#    Then Restored "<members>" should be invited by "Kamala  Harris"
#    Examples:
#      |emailid              |otp      |members                                                                     |Team                           |
#      |hemadrir556@gmail.com|674592   |automationtesting281@gmail.com,testingvitra@gmail.com,testingsel49@gmail.com|Selenium automation testing    |
#
#  @WsTnsRbckData
#  Scenario Outline: user should be able to Delete a Restored and new members
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When In "<Team>" team User should be able to delete a "<RestoredMember>"
#    And he should be able to delete "<newMember>"
#    Then deleted "<RestoredMember>" and "<newMember>" should not exits in Team members dash board
#    Examples:
#      |emailid              |otp      |RestoredMember         |newMember        |Team                        |
#      |hemadrir556@gmail.com|674592   |testingvitra@gmail.com |user2@gmail.com  |Selenium automation testing |
#
#
#
#  @WsTnsRbckData
#  Scenario Outline: teamMember should be able invite a new member and Restore member
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When user should be able to invite a "<newMember>" and "<RestoreMember>" in "<Team>" team
#    And "<invited by>" name should be teamMember name for "<newMember>" in TeamMembers dash board
#    And Invited By name should be TeamOwner name "Kamala  Harris" for "<RestoreMember>" in TeamMembers dash board
#    Then "<newMember>" name should be "Not Recieved" and "<RestoreMember>" name should not be Not Recieved
#    Examples:
#      |emailid                        |otp      |newMember      |RestoreMember          |invited by        |Team                        |
#      |automationtesting281@gmail.com |674592   |user3@gmail.com|testingvitra@gmail.com |Alexander  Kelly  |Selenium automation testing |
#
#  @WsTnsRbckData
#  Scenario Outline: teamMember should be able Delete a new and Restored member
#    Given User fills the Login Page "<emailid>" and "<otp>"
#    When teamMember should be able to delete a "<newmember>" and "<RestoreMember>" in "<Team>" team
#    Then  deleted members "<mailids>" should not exits in TeamMembers dash board
#    Examples:
#      |emailid                         |otp      |newmember      |RestoreMember          |mailids                                |Team                        |
#      |automationtesting281@gmail.com  |674592   |user3@gmail.com|testingsel49@gmail.com |user3@gmail.com,testingsel49@gmail.com |Selenium automation testing |
#
#
