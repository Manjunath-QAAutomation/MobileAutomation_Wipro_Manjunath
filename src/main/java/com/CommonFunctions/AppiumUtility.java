package com.CommonFunctions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import com.Main.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumUtility extends Base {

	/**
	 * @author Manjunath.Karoshi
	 * @description: This method for clicking the element using
	 *               JavascriptExecutor interface
	 * @date : 03/09/2020
	 */
	public static void javaScriptClick(AndroidElement element) throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Javascript click is succesfully performed");
	}

	/**
	 * @author Manjunath.Karoshi
	 * @param driver
	 * @info : Swipe the Page in Horizontal Direction
	 */
	@SuppressWarnings("rawtypes")
	public static void swipeHorizontal(AppiumDriver<MobileElement> driver) {

		System.out.println("Call swipe left...");
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * .15);
		int startPoint = (int) (size.width * .10);
		int endPoint = (int) (size.width * .50);

		System.out.println("Swipe: " + anchor + ", " + startPoint + ", " + endPoint + " and Size: " + size);
		new TouchAction(driver).press(PointOption.point(950, 700))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(100, 700))
				.release().perform();
		System.out.println("Element Swiped...");
	}

	/**
	 * @author Manjunath.Karoshi
	 * @param driver
	 * @info : Scroll to particular text
	 */
	@SuppressWarnings("rawtypes")
	public void scrollToText(String text, AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().textContains(\"" + text + "\"));");
		el.click();
	}

}
