package TBG.Collaterate;

import TBG.Collaterate.Pages.HomePage;
import TBG.Collaterate.Pages.LoginPage;
import TBG.Collaterate.Utils.Log;
import TBG.Collaterate.Utils.ReadYamlConfig;
import com.qa.tbg.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_8_LevelGroup_ImpersonateUser extends BasePage {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homepage;
    @Test
    public void LevelGroup_ImpersonateUser() throws InterruptedException {
        driver=init_driver();
        loginPage=new LoginPage(driver);
        Log.info("Executing : "+this.getClass().getName());
        loginPage.doLogin(ReadYamlConfig.getEmail(),ReadYamlConfig.getPassword());
        Log.info("Logged in to Collatrate Successfully");
        homepage=new HomePage(driver);
        Log.info("Searching for Level Group Store");
        homepage.doSiteSearch("level");
        Log.info("Clicking on Users");
        homepage.clickusertab();
        Log.info("Searching user by Username");
        homepage.searchuser_username("yumi.ogawa");
        homepage.clickImpersonate();
        Log.info("Switching to next tab");
        homepage.switchtochildwindow();
        Assert.assertEquals(homepage.getCurrentUrl(),ReadYamlConfig.getLevelGroupUrl());
        Log.info("Successfully Validated the LevelGroup Url");
        Assert.assertEquals(homepage.getLevelGroupUsername(),"Yumi Ogawa");
        Log.info("Successfully Validated the Username");

    }
}
