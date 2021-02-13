package com.qa.tbg.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

 WebDriver driver;



  public ElementActions(WebDriver driver)
  { this.driver=driver; }
 
  
  public  WebElement getElement(By locator) {
		WebElement element=driver.findElement(locator);
		return element;
		
	}
	public  void doClick(By locator) {
		getElement(locator).click();
	}
	
	public  void doSendKeys(By locator , String text){
		getElement(locator).sendKeys(text);
	}
	 
	
    public  void doClose() {
			 driver.close();
		 }
	 public void doQuit() {
			 driver.quit();
		 }
	
   
     public  String doGetPageTitle(String title) {
	
	   return driver.getTitle();
}

}
