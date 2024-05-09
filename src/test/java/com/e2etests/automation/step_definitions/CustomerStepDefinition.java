package com.e2etests.automation.step_definitions;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.e2etests.automation.page_objects.CustomerPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.RandomValue;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepDefinition {

	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;
	private CustomerPage customerPage  ;
	private Validations validations;
	private Wait wait ;
	private RandomValue randomValue;
	
	public CustomerStepDefinition(){
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.customerPage = new CustomerPage();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
		this.randomValue = new RandomValue();
		
	}
	
	@Given("Je m accede a l espace customer")
	public void jeMAccedeALEspaceCustomer() throws InterruptedException {
	    seleniumUtils.click(customerPage.navcustomers);
	    seleniumUtils.waitForElementToBeClickable(customerPage.btncustomers);
	    seleniumUtils.click(customerPage.btncustomers);
	}
	

	@When("Je clique sur le bouton Add new")
	public void jeCliqueSurLeBoutonAddNew() {
		 seleniumUtils.click(customerPage.addbtn);
	}
	@When("Je saisie l email et password")
	public void jeSaisieLEmailEtPassword() {
	    seleniumUtils.writeText(customerPage.email, configFileReader.getProperties("email"));
	    
	    seleniumUtils.writeText(customerPage.password, configFileReader.getProperties("password"));
	}
	@When("Je select le role")
	public void jeSelectLeRole() throws InterruptedException {
		//((JavascriptExecutor) Setup.getDriver()).executeScript("window.scrollBy(0,700)", "");
		//seleniumUtils.click(customerPage.roleselect);
		//Thread.sleep(2000);
		//seleniumUtils.multiselectByvalue(customerPage.roleselect, customerPage.registeredrole);
		//Thread.sleep(2000);
		//seleniumUtils.multiselectByvalue(customerPage.roleselect, customerPage.guestsrole);
	}
	@When("Je clique sur le bouton save")
	public void jeCliqueSurLeBoutonSave() {
		seleniumUtils.click(customerPage.savebtn);
	}
	@Then("Un message d ajout s affiche")
	public void unMessageDAjoutSAffiche() {
		validations.assertTrue(customerPage.addtext,configFileReader.getProperties("addcustomer"));
	}
	

	@When("Je saisie l email de customer")
	public void jeSaisieLEmailDeCustomer() {
	    seleniumUtils.writeText(customerPage.searchemail, configFileReader.getProperties("email"));
	}
	@When("Je clique sur le bouton search")
	public void jeCliqueSurLeBoutonSearch() {
	   seleniumUtils.click(customerPage.searchebtn);
	   ((JavascriptExecutor) Setup.getDriver()).executeScript("window.scrollBy(0,700)", "");
	}
	@Then("Le cusmtomer s affiche dans le tableau")
	public void leCusmtomerSAfficheDansLeTableau() throws InterruptedException {
		Thread.sleep(2000);
	  validations.assertEquals(customerPage.emailtable, configFileReader.getProperties("email"));
	}
	
	@When("Je saisie l email de customer inexistant")
	public void jeSaisieLEmailDeCustomerInexistant() {
		seleniumUtils.writeText(customerPage.searchemail, randomValue.getSaltString());
	}

	@Then("Le tableau s affiche vide")
	public void leTableauSAfficheVide() throws InterruptedException {
		Thread.sleep(2000);
		validations.assertTrue(customerPage.emptytable,configFileReader.getProperties("emptytable"));
		
	}
	

	
	
	@When("Je clique sur le bouton edit")
	public void jeCliqueSurLeBoutonEdit() {
	    
	}
	@When("Je modifie les information souhaite")
	public void jeModifieLesInformationSouhaite() {
	   
	}
	
	@When("Un messge d update s affiche")
	public void unMessgeDUpdateSAffiche() {
	    
	}
	

	
	
	@When("Je clique sur le bouton delete")
	public void jeCliqueSurLeBoutonDelete() {
	    
	}
	@When("Je clique sur delete d alert")
	public void jeCliqueSurDeleteDAlert() {
	    
	}
	@When("Un messge de delete s affiche")
	public void unMessgeDeDeleteSAffiche() {
	    
	}




}
