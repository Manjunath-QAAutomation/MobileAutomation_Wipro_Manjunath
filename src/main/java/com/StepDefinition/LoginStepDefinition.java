package com.StepDefinition;

import java.io.IOException;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import com.Main.Base;
import com.Pages.HamburgerMenu;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends Base{
	
	/**
	 * @author Manjunath.Karoshi
	 * @Description : launching the app
	 * @date : 11/09/2020
	 */
	@Given("^user launches the app$")
	public void userLaunchesTheapp() throws IOException, InterruptedException  {
		Base.Initialise();		
		HamburgerMenu.clickOnskipSigninbtn();
	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : click on hamburger menu
	 * @date : 11/09/2020
	 */
	@When("^User clicks on hamburger Menu$")
	public void userClicksOnhamburgerMenuICon() throws InterruptedException  {	
		
		HamburgerMenu.clickOnhamburgerMenu();
	}
	
	/**
	 * @author Manjunath.Karoshi
	 * @Description : Login to Amazon application
	 * @date : 11/09/2020
	 */
	@Then("^Login to amazon application$")
	public void login_to_amazon_application() throws Throwable {
		
		driver.rotate(ScreenOrientation.LANDSCAPE);		
		driver.rotate(ScreenOrientation.PORTRAIT);
		
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.signInButton));
		Reporter.log("clcik on sign in button");
		HomePage.signInButton.click();
		Reporter.log("Wait for username field to get visible on the screen");
		wait.until(ExpectedConditions.visibilityOf(LoginPage.usernameField));
		Reporter.log("clcik on username Field");
		LoginPage.usernameField.click();
		LoginPage.usernameField.clear();
		LoginPage.usernameField.sendKeys(prop.getProperty("username"));	
		wait.until(ExpectedConditions.visibilityOf(LoginPage.contiueButton));
		Reporter.log("clcik on continue button");
		LoginPage.contiueButton.click();		
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.passwordField));
		Reporter.log("clcik on password Field");
		LoginPage.passwordField.click();
		LoginPage.passwordField.sendKeys(prop.getProperty("password"));
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginButton));
		Reporter.log("clcik on login button");
		LoginPage.loginButton.click();
		
	}

}
