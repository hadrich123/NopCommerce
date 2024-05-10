package com.e2etests.automation.step_definitions;


import java.time.Duration;

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
	public void jeMAccedeALEspaceCustomer()  {
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
	   seleniumUtils.scrollDown();
	   //((JavascriptExecutor) Setup.getDriver()).executeScript("window.scrollBy(0,700)", "");
	}
	@Then("Le cusmtomer s affiche dans le tableau")
	public void leCusmtomerSAfficheDansLeTableau()  {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10),customerPage.emailtable, "NAN");
	  validations.assertEquals(customerPage.emailtable, configFileReader.getProperties("email"));
	}
	
	@When("Je saisie l email de customer inexistant")
	public void jeSaisieLEmailDeCustomerInexistant() {
		seleniumUtils.writeText(customerPage.searchemail, randomValue.getSaltStringEmail());
	}

	@Then("Le tableau s affiche vide")
	public void leTableauSAfficheVide()  {
		
		wait.forElementToBeDisplayed(Duration.ofSeconds(10), customerPage.emptytable, "NAN");
		
		validations.assertTrue(customerPage.emptytable,configFileReader.getProperties("emptytable"));
		
	}
	

	@When("Je clique sur le bouton edit")
	public void jeCliqueSurLeBoutonEdit() {
		seleniumUtils.scrollDown();
		wait.forElementToBeDisplayed(Duration.ofSeconds(10), customerPage.editbtn, "NAN");
	    seleniumUtils.click(customerPage.editbtn);	}
	@When("Je modifie les information souhaite")
	public void jeModifieLesInformationSouhaite() {
		seleniumUtils.writeText(customerPage.email, randomValue.getSaltStringEmail());
	}
	
	@When("Un messge d update s affiche")
	public void unMessgeDUpdateSAffiche() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10),customerPage.updatetext, "NAN");
		validations.assertTrue(customerPage.updatetext,configFileReader.getProperties("updatecustomer"));
	}
	
	
	@When("Je clique sur le bouton delete")
	public void jeCliqueSurLeBoutonDelete() {
	    seleniumUtils.click(customerPage.deletbtn);
	}
	@When("Je clique sur delete d alert")
	public void jeCliqueSurDeleteDAlert() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10),customerPage.alertdelete, "NAN");
		seleniumUtils.click(customerPage.alertdelete);
	    
	}
	@When("Un messge de delete s affiche")
	public void unMessgeDeDeleteSAffiche() throws InterruptedException {
		validations.assertTrue(customerPage.deletetext,configFileReader.getProperties("deletecustomer"));
	}




}
