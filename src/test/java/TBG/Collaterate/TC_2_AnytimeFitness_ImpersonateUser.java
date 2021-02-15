package TBG.Collaterate;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tbg.base.BasePage;

import TBG.Collaterate.Pages.HomePage;
import TBG.Collaterate.Pages.LoginPage;
import TBG.Collaterate.Utils.Log;
import TBG.Collaterate.Utils.ReadYamlConfig;

public class TC_2_AnytimeFitness_ImpersonateUser extends BasePage {
	 WebDriver driver;
	    LoginPage loginPage;
	    HomePage homepage;
	    @Test
	    public void AnytimeFitness_ImpersonateUser() throws InterruptedException {
	        driver=init_driver();
	        loginPage=new LoginPage(driver);
	        Log.info("Executing : "+this.getClass().getName());
	        loginPage.doLogin(ReadYamlConfig.getEmail(),ReadYamlConfig.getPassword());
	        Log.info("Logged in to Collatrate Successfully");
	        homepage=new HomePage(driver);
	        Log.info("Searching for Anytime Fitness Store");
	        homepage.doSiteSearch("Anytime");
	        Log.info("Clicking on Users");
	        homepage.clickusertab();
	        Log.info("Searching user by Username");
	        homepage.searchuser_username("yumi ogawa");
	        homepage.clickImpersonate();
	        Log.info("Switching to next tab");
	        homepage.switchtochildwindow();
	        Assert.assertEquals(homepage.getCurrentUrl(),ReadYamlConfig.getAnytimeFitnessUrl());
	        Log.info("Successfully Validated the Anytime Fitness Url");
	        Assert.assertEquals(homepage.getAnytimeFitnessUsername(),"Yumi Ogawa");
	        Log.info("Successfully Validated the Username");

	    }
	}



