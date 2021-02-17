package TBG.Collaterate;

import TBG.Collaterate.Pages.LoginPage;
import TBG.Collaterate.Utils.Log;
import TBG.Collaterate.Utils.ReadYamlConfig;
import com.qa.tbg.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_2_Invalid_Login_EmptyUsername extends BasePage{
	WebDriver driver;
	LoginPage loginPage;

    @Test
    public void Invalid_loginTest() throws InterruptedException {
        driver=init_driver();
        loginPage=new LoginPage(driver);
        Log.info("Executing : "+this.getClass().getName());
		loginPage.doLogin("",ReadYamlConfig.getPassword());
        Log.info(loginPage.geterrorText());
        Assert.assertEquals("Email is required",loginPage.geterrorText());
        Log.pass(this.getClass().getName()+" : Passed Successfully");
        
        
		}


}
