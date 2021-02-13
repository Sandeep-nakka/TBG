package TBG.Collaterate.Pages;

import com.qa.tbg.base.Constants;
import com.qa.tbg.base.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	WebDriver driver;
	ElementActions elementActions;
	

	// 1. By locators - Page Objects
     By email = By.id("USERNAMEEF");
	 By password = By.id("PASSWORDEF");
	 By signin= By.id("signIn");
	

	// 2. Constructor of page class:
	public LoginPage(WebDriver driver) 
	{ 
		this.driver = driver; 
	   elementActions = new ElementActions(this.driver);
	}
	 

		// 3. page actions/methods:
		public   String getPageTitle() {
			return elementActions.doGetPageTitle(Constants.LOGIN_PAGE_TITLE);
			
		}

	    public  void doLogin(String emailId, String pwd) {
			 System.out.println("entering doLogin");
		     elementActions.doSendKeys(email, emailId);
			 elementActions.doSendKeys(password, pwd);
			 elementActions.doClick(signin);

			
		} 

	

}
