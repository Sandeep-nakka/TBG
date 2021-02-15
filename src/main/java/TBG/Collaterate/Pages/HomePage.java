package TBG.Collaterate.Pages;

import com.qa.tbg.base.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class HomePage {
    WebDriver driver;
    ElementActions elementActions;

    By SiteSearchid= By.xpath("//input[@id='siteSearchInput']");
    By Selectfirstid= By.xpath("//a[@id='aSite0']");
    By Usertab=By.xpath("//a[normalize-space()='Users']");
    By SearchUsername=By.xpath("//input[@id='CUSTOMERUSERNAMEEF']");
    By SearchButton=By.xpath("//button[normalize-space()='Search']");
    By Impersonateicon=By.xpath("//*[contains(@class,'impersonate')]");
    By Getsearchusername=By.xpath("//tr[@class='userStatusIsActive']/td[2]");
    By EdgeLevelUsername=By.xpath("//span[@class='userFullName']");
    By AnytimeFitnessUsername=By.xpath("//span[@class='userFullName']");
    By MODUsername=By.xpath("//span[@class='userFullName']");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        elementActions = new ElementActions(this.driver);
    }

    public void doSiteSearch(String sitesearch){
        elementActions.doSendKeys(SiteSearchid,sitesearch);
        elementActions.doClick(Selectfirstid);

    }
    public void clickusertab(){
        elementActions.doClick(Usertab);
    }
    public void searchuser_username(String user){
        elementActions.doSendKeys(SearchUsername,user);
        elementActions.doClick(SearchButton);
    }
    public void clickImpersonate(){
        elementActions.Scrollpage();
        elementActions.doClick(Impersonateicon);
    }
    public String getSearchedUsername(){
        return elementActions.doGetText(Getsearchusername);
    }
    public void swtichnexttab(){
        elementActions.Switchnexttab();
    }
    public void switchprevioustab(){
        elementActions.Switchprevioustab();
    }
    public String getCurrentUrl(){
        return elementActions.doGetCurrentUrl();
    }
    public  String getEdgewoodUsername(){
        return elementActions.doGetText(EdgeLevelUsername);
    }
    public  String getLevelGroupUsername(){
        return elementActions.doGetText(EdgeLevelUsername);
    }
    public  String getAnytimeFitnessUsername(){
        return elementActions.doGetText(AnytimeFitnessUsername);
    }
    public  String getMODUsername(){
        return elementActions.doGetText(MODUsername);
    }
    public void switchdefaultcontent(){
        elementActions.getDefaultContent();
    }
    public void switchtochildwindow(){
        String Parentwindow=elementActions.windowhandle();
        Set<String> handles=elementActions.windowhandles();
        Iterator<String> itr=handles.iterator();
        if(itr.hasNext()){
            String parentwindow=itr.next();
            String childwindow=itr.next();
            elementActions.switchwindow(childwindow);
        }
    }

}
