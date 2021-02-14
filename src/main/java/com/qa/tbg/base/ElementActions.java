package com.qa.tbg.base;


import org.openqa.selenium.*;

import java.util.Set;

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
	
   
     public  String doGetPageTitle() {
	   return driver.getTitle();
}
public String doGetCurrentUrl(){
  	return driver.getCurrentUrl();
}
public String doGetText(By locator){
  	return getElement(locator).getText();
}
public void Switchnexttab(){
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
}
public void Switchprevioustab(){
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");

}
public void Scrollpage(){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
}
public void getDefaultContent(){
  	driver.switchTo().defaultContent();
}
public String windowhandle(){
  	return driver.getWindowHandle();
}
public Set<String> windowhandles(){
  	Set<String> handles=driver.getWindowHandles();
  	return handles;
}
public void switchwindow(String window){
  	driver.switchTo().window(window);
}
}
