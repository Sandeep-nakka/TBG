package TBG.Collaterate.Utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

WebDriver driver;
	public ElementActions(WebDriver driver) {
		this.driver=driver;
		
	}
	public WebElement getElement(By locator) {
		WebElement element=driver.findElement(locator);
		return element;
		
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}
	public void doActionsClick(By locator) {
		Actions action=new Actions(driver);
		action.click(getElement(locator)).perform();
	}
	public void doSendKeys(By locator , String text){
		getElement(locator).sendKeys(text);
	}
	public void doActionsSendKeys(By locator ,String text) {
		Actions action=new Actions(driver);
		action.sendKeys(getElement(locator),text).perform();
	}
	public void doDoubleClick(By locator) {
		Actions action=new Actions(driver);
		action.doubleClick();
	}
	public void doRightClick(By locator) {
		Actions action=new Actions(driver);
		action.contextClick();
	}
	public void doDragAndDrop(By src,By target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(getElement(src),getElement(target)).build().perform();
	}
	public String doGetText(By locator) {
		return getElement(locator).getText();
		
	}
	public boolean doIsDisplayed(By locator) {
		return 	getElement(locator).isDisplayed();
		
	}
	public boolean doIsSelected(By locator) {
		return 	getElement(locator).isSelected();
			
	}
   public boolean doIsEnabled(By locator) {
		 return getElement(locator).isEnabled();
   }
		 public void doClose() {
			 driver.close();
		 }
		 public void doQuit() {
			 driver.quit();
		 }
	
   public void selectDropDownByVisibleText(By locator ,String text) {
	   Select select =new Select(getElement(locator));
	   select.selectByVisibleText(text);
   }
   public void selectDropDownByValue(By locator ,String text) {
	   Select select =new Select(getElement(locator));
	   select.selectByValue(text);
   }
   public void selectDropDownByIndex(By locator ,int index) {
	   Select select =new Select(getElement(locator));
	   select.selectByIndex(index);
   }
public int getDropDownOptionsCount(By locator) {
	Select select= new Select(getElement(locator));
	List<WebElement> list=select.getOptions();
	int count=list.size();
	return count;
	
}
public List<String> getDropDownOptions(By locator) {
	List<String> stringList=new ArrayList<String>();
	Select select= new Select(getElement(locator));
	List<WebElement> list=select.getOptions();
	for(WebElement e:list) {
		String text=e.getText();
		stringList.add(text);
	}
	return stringList;
}
//public String waitUntilGetPageTitle(int timeout, String title){
//
//	WebDriverWait wait=new WebDriverWait(driver, 200);
//	wait.until(ExpectedConditions.titleIs(title));
//	return driver.getTitle();
//}

}
