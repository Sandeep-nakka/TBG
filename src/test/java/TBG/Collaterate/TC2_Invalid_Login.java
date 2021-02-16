package TBG.Collaterate;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tbg.base.BasePage;

import TBG.Collaterate.Pages.LoginPage;
import TBG.Collaterate.Utils.Log;
import TBG.Collaterate.Utils.ReadYamlConfig;

public class TC2_Invalid_Login extends BasePage{
	WebDriver driver;
	LoginPage loginPage;

    @Test
    public void Invalid_loginTest() throws InterruptedException {
        driver=init_driver();
        loginPage=new LoginPage(driver);
        Log.info("Executing : "+this.getClass().getName());
		loginPage.doLogin("melissa.wie@thebernardgroup.com",ReadYamlConfig.getPassword());
        Log.info(loginPage.getusermessage());
        Assert.assertEquals("Username not found",loginPage.getusermessage());
        Log.pass(this.getClass().getName()+" : Passed Successfully");
        
        
		}


}
