package TBG.Collaterate;
import TBG.Collaterate.Pages.LoginPage;
import TBG.Collaterate.Utils.Log;
import TBG.Collaterate.Utils.ReadYamlConfig;
import com.qa.tbg.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePage{
	WebDriver driver;
	
	LoginPage loginPage;

    @BeforeTest
    public  void intializetest(){
        driver= init_driver();
      
		loginPage = new LoginPage(driver);
		
    }
    @Test
    public void Test(){
        Log.info("Testing");
    }
    @Test
    public void loginTest() {
		loginPage.doLogin(ReadYamlConfig.getEmail(),ReadYamlConfig.getPassword());
		
	}

  //  @AfterTest
 //   public void closebrowser(){
 //       driver.close();
   // }

}
