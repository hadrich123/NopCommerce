package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.AuthentificationPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AuthentificationStepDefinition {
	
	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;
	private AuthentificationPage authentificationPage  ;
	private Validations validations;
	
	public AuthentificationStepDefinition(){
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.authentificationPage = new AuthentificationPage();
		this.validations = new Validations();
		
	}

	@Given("Je me connecte a l application")
	public void jeMeConnecteALApplication() {
		seleniumUtils.get(configFileReader.getProperties("home.url"));
	    seleniumUtils.writeText(authentificationPage.email, configFileReader.getProperties("home.login"));
	    seleniumUtils.writeText(authentificationPage.password,configFileReader.getProperties("home.password"));
	    seleniumUtils.click(authentificationPage.loginbtn);
	}
	@Then("Je me redirige vers le dashboard")
	public void jeMeRedirigeVersLeDashboard() {
	   validations.assertEquals(authentificationPage.dashboard, configFileReader.getProperties("home.message"));
	}
	

	@Given("Je me connecte a l application avec incorrecte cordonne")
	public void jeMeConnecteALApplicationAvecIncorrecteCordonne() {
		seleniumUtils.get(configFileReader.getProperties("home.url"));
		seleniumUtils.writeText(authentificationPage.email, configFileReader.getProperties("home.loginNp"));
	    seleniumUtils.writeText(authentificationPage.password,configFileReader.getProperties("home.passwordNp"));
	    seleniumUtils.click(authentificationPage.loginbtn);
	}
	@Then("Un message d erreur est affiche")
	public void unMessageDErreurEstAffiche() {
		validations.assertTrue(authentificationPage.errortext, configFileReader.getProperties("home.error"));
		
	}
	





}
