package com.horwell.matthew.tea.tasting.website.test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.horwell.matthew.tea.tasting.website.LandingPage;
import com.horwell.matthew.tea.tasting.website.MenuPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TeaSiteSteps {

	WebElement element;

	WebDriverWait wait;
	MenuPage menuPage;
	LandingPage landingPage;
	ExtentTest test;

	WebDriver driver;
		

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", Constant.FIREFOXDRIVERPATH + Constant.FIREFOXDRIVER);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		test = TestRunner.report.startTest("Test");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get(Constant.URL);
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		test.log(LogStatus.INFO, "Landing page loaded");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		landingPage.goToMenu();
		menuPage = PageFactory.initElements(driver, MenuPage.class);
		test.log(LogStatus.INFO, "Menu page loaded");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		if (menuPage.getTeaList().equals("Green Tea, Red Tea, Oolong Tea")) {
			test.log(LogStatus.PASS, "All teas are listed");
		} else {
			test.log(LogStatus.PASS, "Teas aren't listed");
		}
		assertEquals("Green Tea, Red Tea, Oolong Tea", menuPage.getTeaList());
		TestRunner.report.endTest(test);
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		landingPage.goToCheckoutPage();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("http://www.practiceselenium.com/check-out.html")) {
			test.log(LogStatus.PASS, "Checkout page loaded successfully");
		} else {
			test.log(LogStatus.PASS, "At incorrect URL");
		}
		assertEquals("http://www.practiceselenium.com/check-out.html", currentURL);
		TestRunner.report.endTest(test);
	}
	

}
