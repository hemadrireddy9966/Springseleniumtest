package com.example.VitraAi.cache;


import com.example.VitraAi.pageactions.*;
import org.openqa.selenium.WebDriver;


public class Cache {

    public WebDriver driver;
    public String emailID="";
    public Cache(WebDriver driver) {
      this.driver = driver;
    }


    public WsTnsLoginPage getWsTns(){
        WsTnsLoginPage wt = new WsTnsLoginPage(driver);
        return wt;
    }
    public LoginAndSignpage getGoogle(){
        LoginAndSignpage google = new LoginAndSignpage(driver);
        return google;
    }
    public WsTnsRback getWsRbck(){
        WsTnsRback rback= new WsTnsRback(driver);
        return rback;
    }
    public WsTnsCommonMethods getWsCommon(){
        WsTnsCommonMethods common = new WsTnsCommonMethods(driver);
        return common;
    }
    public WsTnsGlossary getGlossary(){
        WsTnsGlossary glossary = new WsTnsGlossary(driver);
        return glossary;
    }
    public WebSitesTab getWebsite(){
        WebSitesTab w=new WebSitesTab(driver);
        return w;
    }
    public websiteGlossary getWebsiteGlossary(){
        websiteGlossary w=new websiteGlossary(driver);
        return w;
    }


}