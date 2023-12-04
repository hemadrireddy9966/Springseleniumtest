package com.example.VitraAi.steps;


import com.example.VitraAi.cache.Cache;
import com.example.VitraAi.pageactions.WsTnsCommonMethods;
import com.example.VitraAi.pageactions.WsTnsLoginPage;
import com.example.VitraAi.pageactions.WsTnsRback;
import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class WsTnsRbckSteps extends Cache implements En {

    WsTnsLoginPage wst = super.getWsTns();
    WsTnsRback r = super.getWsRbck();
    WsTnsCommonMethods c=super.getWsCommon();


    public WsTnsRbckSteps(WebDriver driver) {
        super(driver);

        When("User should be create a {string} and if it exits he should able to open", (String teamName) -> {
            c.navigatingToTeams();
            r.createNewTeamIfNotExits(teamName,"testing");
            r.openTeam(teamName);
        });

        When("user should be able to verify his {string} in TeamMembers and glossary tabs", (String teamName) -> {
            r.teamNameVerifyInTeammembersAndGlossary(teamName);
        });

        When("user should be able to verify his own {string} in teamMembers and invited by should be {string}", (String emailid, String inviteBy) -> {
            r.emailVerifyInTeamMembersTab(emailid);
            r.inviteByVerifyInTeamMembersTab(emailid,inviteBy);
        });

        When("user should be able to invite a newMembers {string} and able verify invited members mails and {string} in teammembers dash board", (String mailids, String invitedBy) -> {
            r.teamMemberInvite(mailids);
            r.emailVerifyInTeamMembersTab(mailids);
            r.inviteByVerifyInTeamMembersTab(mailids,invitedBy);
        });

        Then("invited {string} name should be {string} in TeamMembers Tab", (String members, String teamMemberName) -> {
            r.nameVerifyInTeamMembersTab(members,teamMemberName);
        });

        When("In {string} team user should be able to restore {string} in teammembers dash board", (String teamName,String mailids) -> {
            c.navigatingToTeams();
            r.teamSearchInTeamsTab(teamName);
            r.openTeam(teamName);
            r.teamMemberInvite(mailids);
        });

        When("Restored {string} names should not be {string}", (String members,String teamMemberName) -> {
            r.nameVerifyAgainstNotRecievedInTeamMembersTab(members,teamMemberName);
        });

        Then("Restored {string} should be invited by {string}", (String members,String invitedBy) -> {
            r.inviteByVerifyInTeamMembersTab(members,invitedBy);
        });

        When("In {string} team User should be able to delete a {string}", (String teamName,String restoredMember) -> {
            c.navigatingToTeams();
            r.teamSearchInTeamsTab(teamName);
            r.openTeam(teamName);
            r.teamMemberDelete(restoredMember);
            r.teamMemberDeleteNotifi();
        });

        When("he should be able to delete {string}", (String newMember) -> {
            r.teamMemberDelete(newMember);
            r.teamMemberDeleteNotifi();
        });

        Then("deleted {string} and {string} should not exits in Team members dash board", (String restoreMember, String newMember) -> {
            r.emailVerifyAgainstInTeamMembersTab(restoreMember);
            r.emailVerifyAgainstInTeamMembersTab(newMember);

        });
        When("user should be able to invite a {string} and {string} in {string} team", (String newMember, String restoreMember,String teamName) -> {
            c.navigatingToTeams();
            r.teamSearchInTeamsTab(teamName);
            r.openTeam(teamName);
            Thread.sleep(4000);
            r.teamMemberInvite(newMember);
            r.teamMemberAddedNotifi();
            r.teamMemberInvite(restoreMember);
            r.teamMemberRestoreNotifi();
        });

        And("{string} name should be teamMember name for {string} in TeamMembers dash board", (String invitedBy,String newMember) -> {
           r.emailVerifyInTeamMembersTab(newMember);
           r.inviteByVerifyInTeamMembersTab(newMember,invitedBy);
        });
        And("Invited By name should be TeamOwner name {string} for {string} in TeamMembers dash board", (String invitedBy,String newMember) -> {
           r.emailVerifyInTeamMembersTab(newMember);
           r.inviteByVerifyInTeamMembersTab(newMember,invitedBy);
        });

        Then("{string} name should be {string} and {string} name should not be Not Recieved", (String newMember, String invitedBy, String restoreMember) -> {
            r.nameVerifyAgainstNotRecievedInTeamMembersTab(newMember,invitedBy);
            r.nameVerifyAgainstNotRecievedInTeamMembersTab(restoreMember,invitedBy);
        });
        When("teamMember should be able to delete a {string} and {string} in {string} team", (String newMember, String resoredMember,String teamName) -> {
            c.navigatingToTeams();
            r.teamSearchInTeamsTab(teamName);
            r.openTeam(teamName);
            r.teamMemberDelete(newMember);
            r.teamMemberDeleteNotifi();
            r.teamMemberDelete(resoredMember);
            r.teamMemberDeleteNotifi();
        });

        Then("deleted members {string} should not exits in TeamMembers dash board", (String emails) -> {
           r.emailVerifyAgainstInTeamMembersTab(emails);
        });
    }
}
