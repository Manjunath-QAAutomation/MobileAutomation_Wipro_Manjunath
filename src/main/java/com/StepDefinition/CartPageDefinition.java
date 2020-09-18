package com.StepDefinition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Main.Base;
import com.Pages.CartPage;
import com.Pages.HomePage;
import com.Pages.ProductPage;

import cucumber.api.java.en.Then;

public class CartPageDefinition extends Base {

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Navigate to cart menu
	 * @date : 11/09/2020
	 */
	@Then("^Navigate to the Cart menu$")
	public void navigate_to_the_cart_menu() {

		wait.until(ExpectedConditions.elementToBeClickable(HomePage.AmazonLogo));
		HomePage.AmazonLogo.click();
		wait.until(ExpectedConditions.elementToBeClickable(CartPage.CartMenu));
		CartPage.CartMenu.click();
	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Verify the product
	 * @date : 11/09/2020
	 */
	@Then("^Verify the Product in Cart$")
	public void verify_Cart() {

		String ProductCartPage = ProductPage.ProdcutName.getText();
		System.out.println(ProductCartPage);
		Assert.assertTrue(ProductPage.ProdcutName.isDisplayed());
		Assert.assertTrue(ProductCartPage.contains("TV"), "The product is not present in the Cart");
	}

	/**
	 * @author Manjunath.Karoshi
	 * @Description : Clicks on proceed to Buy Button
	 * @date : 11/09/2020
	 */
	@Then("^User clicks on Proceed to Buy button$")
	public void user_clicks_on_Proceed_to_Buy_button() throws Throwable {

		wait.until(ExpectedConditions.elementToBeClickable(CartPage.ProceedToBuy));
		CartPage.ProceedToBuy.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(CartPage.AddMobileNumber));
			System.out.println("Enter your Mobile Number to procced  Order");
		} catch (Exception E) {
			System.out.println("Enter Address to procced your Order");
		}

	}

}
