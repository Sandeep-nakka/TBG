package TBG.Collaterate;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tbg.base.BasePage;

import TBG.Collaterate.Pages.HomePage;
import TBG.Collaterate.Pages.LoginPage;
import TBG.Collaterate.Utils.Log;
import TBG.Collaterate.Utils.ReadYamlConfig;

public class TC_5_SearchUser_MOD extends BasePage  {
	WebDriver driver;
    LoginPage loginPage;
    HomePage homepage;
    @Test
    public void SearchUser_MOD() throws InterruptedException {
        driver=init_driver();
        loginPage=new LoginPage(driver);
        Log.info("Executing : "+this.getClass().getName());
        loginPage.doLogin(ReadYamlConfig.getEmail(),ReadYamlConfig.getPassword());
        Log.info("Logged in to Collaterate Successfully");
        homepage=new HomePage(driver);
        Log.info("Searching for  MOD store");
        homepage.doSiteSearch("MOD");
        Log.info("Clicking on Users");
        homepage.clickusertab();
        Log.info("Searching user by Username");
        homepage.searchuser_username("agonzal3");
        Assert.assertEquals(homepage.getSearchedUsername(),"agonzal3");


    }
}



