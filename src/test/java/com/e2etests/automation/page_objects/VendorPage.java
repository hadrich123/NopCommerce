package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class VendorPage {

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
	public static WebElement navcustomers  ;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Vendors']")
	public static WebElement btnvendor  ;
	@FindBy(how = How.ID, using = "SearchName")
	 public static WebElement searchName   ;
	
	@FindBy(how = How.ID, using = "search-vendors")
	 public static WebElement  searchbtn  ;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Edit']")
	 public static WebElement editbtn   ;
	
	@FindBy(how = How.ID, using = "Name")
	 public static WebElement name   ;
	
	@FindBy(how = How.XPATH, using = "//button[@name='save']")
	 public static WebElement savebtn   ;
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success alert-dismissable']")
	 public static WebElement updatetext   ;
	
	@FindBy(how = How.XPATH, using = "//td[normalize-space()='Vendor 2']")
	 public static WebElement nametable;
	
	
	
	
	
	
	
public  VendorPage() {
		
		PageFactory.initElements(Setup.driver, this);}
}
