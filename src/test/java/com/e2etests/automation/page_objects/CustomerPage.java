package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class CustomerPage {
	
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
	public static WebElement navcustomers  ;
	
	@FindBy(how = How.CSS, using = "li[class='nav-item has-treeview menu-is-opening menu-open'] li:nth-child(1)")
	public static WebElement btncustomers  ;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	public static WebElement addbtn  ;
	
	@FindBy(how = How.ID, using = "SearchEmail")
	public static WebElement searchemail  ;
	
	@FindBy(how = How.ID, using = "Email")
	public static WebElement email  ;
	
	@FindBy(how = How.ID, using = "Password")
	public static WebElement password  ;
    
	@FindBy(how = How.NAME, using ="save")
	public static WebElement savebtn ;
	
    @FindBy(how = How.XPATH, using ="//span[@aria-expanded='true']")
    public static WebElement roleselect ;
    
    @FindBy(how = How.ID, using = "select2-SelectedCustomerRoleIds-result-gut3-3")
	public static WebElement registeredrole  ;
    
    @FindBy(how = How.ID, using = "select2-SelectedCustomerRoleIds-result-j11t-4")
   	public static WebElement guestsrole  ;
    
    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-success alert-dismissable']")
   	public static WebElement addtext  ;
    
  
    
	public  CustomerPage() {
		PageFactory.initElements(Setup.driver, this);}
	
}
