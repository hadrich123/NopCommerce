package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class AuthentificationPage {

	@FindBy(how = How.ID, using = "Email")
	public static WebElement email ;
	
	@FindBy(how = How.ID, using = "Password")
	public static WebElement password  ;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement loginbtn  ;
	
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='message-error validation-summary-errors']")
	public static WebElement errortext  ;
	
	@FindBy(how = How.XPATH , using = "//h1[contains(text(),'Dashboard')]")
	public static WebElement dashboard;
	

	
	public  AuthentificationPage() {
	PageFactory.initElements(Setup.driver, this);}
}
