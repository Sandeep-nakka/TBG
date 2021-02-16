package TBG.Collaterate;
import TBG.Collaterate.Pages.LoginPage;
import TBG.Collaterate.Utils.ReadYamlConfig;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.tbg.base.BasePage;
import TBG.Collaterate.Utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Locale;

public class TC1_LoginPageTest extends BasePage{
	WebDriver driver;
	LoginPage loginPage;

    @Test
    public void loginTest() throws InterruptedException {
        driver=init_driver();
        loginPage=new LoginPage(driver);
        Log.info("Executing : "+this.getClass().getName());
		loginPage.doLogin(ReadYamlConfig.getEmail(),ReadYamlConfig.getPassword());
        Assert.assertEquals(loginPage.getPageTitle(), "Collaterate - Dashboard");
        Assert.assertTrue(loginPage.getCurrentUrl().contains("dashboard"));
        Assert.assertTrue(ReadYamlConfig.getEmail().contains(loginPage.getLoggeduser().replace(" ",".").toLowerCase()));

		
	}


}
