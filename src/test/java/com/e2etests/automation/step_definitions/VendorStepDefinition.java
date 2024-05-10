package com.e2etests.automation.step_definitions;


import java.time.Duration;

import com.e2etests.automation.page_objects.VendorPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.RandomValue;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorStepDefinition {
	
	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;
	private VendorPage vendorPage  ;
	private Validations validations;
	private Wait wait ;
	private RandomValue randomValue;
	
	public VendorStepDefinition(){
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.vendorPage = new VendorPage();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
		this.randomValue = new RandomValue();
	}


	@Given("Je m accede a l espace vendors")
	public void jeMAccedeALEspaceVendors() {
		seleniumUtils.click(vendorPage.navcustomers);
	    seleniumUtils.waitForElementToBeClickable(vendorPage.btnvendor);
	    seleniumUtils.click(vendorPage.btnvendor);  
	}
	@When("Je saisie le nom de vendor")
	public void jeSaisieLeNomDeVendor() {
	    seleniumUtils.writeText(vendorPage.searchName, configFileReader.getProperties("vendorName"));
	}
	@When("Je clique sur le bouton search vendor")
	public void jeCliqueSurLeBoutonSearchVendor() {
	   seleniumUtils.click(vendorPage.searchbtn);
	}
	@Then("Le vendor s affiche dans le tableau")
	public void leVendorSAfficheDansLeTableau() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10),vendorPage.nametable, "NAN");
		  validations.assertEquals(VendorPage.nametable, configFileReader.getProperties("vendorName"));
	}

	
	@When("Je clique sur le bouton edit vendor")
	public void jeCliqueSurLeBoutonEditVendor() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10), vendorPage.editbtn, "NAN");
	    seleniumUtils.click(vendorPage.editbtn);	
	}
	@When("Je modifie les information de vendor")
	public void jeModifieLesInformationDeVendor() {
	    seleniumUtils.writeText(vendorPage.name, randomValue.getSaltString());
	}
	@When("Je clique sur le bouton save des modifications")
	public void jeCliqueSurLeBoutonSaveDesModifications() {
	    seleniumUtils.click(vendorPage.savebtn);
	}
	@When("Un messge d update de vendor s affiche")
	public void unMessgeDUpdateDeVendorSAffiche() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10),vendorPage.updatetext, "NAN");
		validations.assertTrue(vendorPage.updatetext,configFileReader.getProperties("updateVendor"));
	}





}
