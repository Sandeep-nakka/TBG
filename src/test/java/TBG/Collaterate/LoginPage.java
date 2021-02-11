package TBG.Collaterate;


import TBG.Collaterate.Utils.Log;
import com.qa.tbg.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

    public WebDriver driver;
    @BeforeTest
    public void intializetest(){
        driver=init_driver();
    }
    @Test
    public void Test(){
        Log.info("Testing");
    }

    @AfterTest
    public void closebrowser(){
        driver.close();
    }

}
