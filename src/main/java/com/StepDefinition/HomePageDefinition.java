package com.StepDefinition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.CommonFunctions.AppiumUtility;
import com.Main.Base;
import com.Pages.CartPage;
import com.Pages.HomePage;
import com.Pages.ProductPage;

import cucumber.api.java.en.Then;

public class HomePageDefinition extends Base {

	AppiumUtility appiumutility = new AppiumUtility();
	public static String ProductName = null;

	/**
	 * @author Manjunath.Karoshi
	 * @Description : validate the Amazon logo
	 * @date : 11/09/2020
	 */
	@Then("^Validate text Amazon Logo is displayed$")
	public void validate_text_Amazon_Logo_is_displayed() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(HomePage.AmazonLogo));
		Assert.assertTrue(HomePage.AmazonLogo.isDisplayed());
	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Click on Amazon button
	 * @date : 11/09/2020
	 */
	@Then("^User clicks on Amazon button$")
	public void user_clicks_on_Amazon_button() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.AmazonLogo));
		HomePage.AmazonLogo.click();
	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Validate the search bar
	 * @date : 11/09/2020
	 */
	@Then("^Validate Search Bar is displayed$")
	public void validate_Search_Bar_is_displayed() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(HomePage.HomeSearch));
		Assert.assertTrue(HomePage.HomeSearch.isDisplayed());

	}

	@SuppressWarnings("static-access")
	@Then("^Verify the Suggestion on the Home Page$")
	public void verify_the_Suggestion_on_the_Home_Page() throws Throwable {
		appiumutility.swipeHorizontal(driver);
	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Choose the current location
	 * @date : 11/09/2020
	 */
	@Then("^Choose the current location$")
	public void choose_the_current_location() throws Throwable {

		wait.until(ExpectedConditions.elementToBeClickable(HomePage.AmazonLogo));
		HomePage.AmazonLogo.click();
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.Devliver));
		HomePage.Devliver.click();
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.useCurrentLocation));
		HomePage.useCurrentLocation.click();
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.AllowPermission));
		HomePage.AllowPermission.click();

	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Search for the product
	 * @date : 11/09/2020
	 */
	@Then("^Search for the product \"([^\"]*)\"$")
	public void search_for_the_product_inch_TV(String Product) throws Throwable {

		if (Product.equals("65-inch TV")) {

			wait.until(ExpectedConditions.visibilityOf(HomePage.HomeSearch));
			Assert.assertTrue(HomePage.HomeSearch.isDisplayed());
			HomePage.HomeSearch.click();
			try {
				CartPage.ClearSearch.click();
			} catch (Exception E) {

				System.out.println("Searching for the First Time");
			}
			HomePage.HomeSearch.sendKeys("65-inch");
			wait.until(ExpectedConditions.elementToBeClickable(HomePage.SearchDropDown));
			HomePage.SearchDropDown.click();

		}

	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Validate 65 inch tv is displayed or not
	 * @date : 11/09/2020
	 */
	@Then("^Validate \"([^\"]*)\" is displayed$")
	public void validate_options_menu(String Product) {
		if (Product.equals("65-inch TV")) {
			wait.until(ExpectedConditions.visibilityOf(HomePage.ResultsCount));
			Assert.assertTrue(HomePage.ResultsCount.isDisplayed());
		}
	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Selects the product from the list
	 * @date : 10/09/2020
	 */
	@Then("^User selects the product from the list$")
	public void user_selects_the_product_from_the_list() throws Throwable {

		appiumutility.scrollToText("Samsung", driver);
		wait.until(ExpectedConditions.visibilityOf(ProductPage.RandomResult));
		Assert.assertTrue(ProductPage.RandomResult.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(ProductPage.Inches));
		Assert.assertTrue(ProductPage.Inches.isDisplayed());
		
		
	}

	@Then("^Verify product details are displayed$")
	public void verify_product_details_are_displayed() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(ProductPage.ProdcutName));
		System.out.println("Product details"+ProductPage.ProdcutName.getAttribute("text"));
	    ProductName = ProductPage.ProdcutName.getText();
		System.out.println("Productname: "+ProductName);
		Assert.assertTrue(ProductName.contains("TV"), "The suggestions are not having expected Product");

	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Verify the details
	 * @date : 10/09/2020
	 */
	@Then("^User Verifies the details of the selected Product$")
	public void user_Verifies_the_details_of_the_selected_Product() throws Throwable {
		
		String ProductDetailsPage = ProductPage.ProdcutName.getText();
		System.out.println(ProductDetailsPage);
		Assert.assertEquals(ProductDetailsPage, ProductName);
		String ProductPrice = ProductPage.Price.getText();
		System.out.println("The Price of the Choosen Prodcut is: " + ProductPrice);

	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Add the product to cart
	 * @date : 10/09/2020
	 */
	@Then("^User Add's the product to the Cart$")
	public void user_Add_s_the_product_to_the_Cart() throws Throwable {
		Thread.sleep(5000);
		appiumutility.scrollToText("Add to Cart", driver);
		

	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Close the app
	 * @date : 10/09/2020
	 */
	@Then("^User closes the app$")
	public void user_closes_the_app() throws Throwable {

		driver.closeApp();
	}

}
