package moon;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationObject extends PageObjectSuperClass {

	protected FluentWait<WebDriver> wait;

	@FindBy(className="login")
	WebElement loginButton;

	@FindBy(id="email_create")
	WebElement createAccountEmailField;

	@FindBy(id="SubmitCreate")
	WebElement createAccountButton;

	@FindBy(xpath="//*[@id='account-creation_form']/div[1]/h3")
	WebElement personalInformationText;

	@FindBy(id="customer_firstname")
	WebElement firstNameField;

	@FindBy(id="customer_lastname")
	WebElement lastNameField;

	@FindBy(id="email")
	WebElement emailField;

	@FindBy(id="passwd")
	WebElement passwordField;

	@FindBy(id="firstname")
	WebElement firstNameAddressField;

	@FindBy(id="lastname")
	WebElement lastNameAddressField;

	@FindBy(id="days")
	WebElement days;

	@FindBy(id="months")
	WebElement months;

	@FindBy(id="years")
	WebElement years;

	@FindBy(id="address1")
	WebElement addressField;

	@FindBy(id="city")
	WebElement cityField;

	@FindBy(id="id_state")
	WebElement states;

	@FindBy(id="postcode")
	WebElement zipField;

	@FindBy(id="phone_mobile")
	WebElement phoneField;

	@FindBy(id="submitAccount")
	WebElement registerButton;	

	@FindBy(xpath="//*[@id='center_column']/h1")
	WebElement myAccountText;

	private String email;

	public AccountCreationObject(WebDriver driverInstance) {
		super(driverInstance);
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(100));
	}

	public AccountCreationObject goToPage() {
		navigate();
		return this;
	}

	public AccountCreationObject clickButton(String text) {
		switch(text) {
		case "login":
			loginButton.click();
			break;
		case "register":
			registerButton.click();
			break;
		default:
			System.out.println(text + " is not a recognized button");
		}
		return this;
	}

	public AccountCreationObject enterValidEmailAndSubmit() {
		while(true) {
			generateEmail();
			createAccountEmailField.sendKeys(email);
			createAccountButton.click();
			if(personalInformationText.getText().equals("YOUR PERSONAL INFORMATION")) {
				return this;
			}
		}
	}

	public AccountCreationObject fillOutFields() {
		firstNameField.sendKeys("Test");
		lastNameField.sendKeys("Test");
		passwordField.sendKeys("12345");
		dateOfBirth(); // Temporary Method
		firstNameAddressField.sendKeys("Test");
		lastNameAddressField.sendKeys("Test");
		addressField.sendKeys("Test");
		cityField.sendKeys("Test");
		state(); // Temporary Method
		zipField.sendKeys("99999");
		phoneField.sendKeys("5555555555");		
		return this;
	}

	public String getSignedInText() {
		return myAccountText.getText();
	}

	private void generateEmail() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(89999) + 10000;
		String randomEmailNumber = Integer.toString(randomNumber);
		email = randomEmailNumber + "@gmail.com";
	}

	// Temporary Method
	private void dateOfBirth() {
		Select dayBox = new Select(days);
		Select monthBox = new Select(months);
		Select yearBox = new Select(years);
		dayBox.selectByValue("1");
		monthBox.selectByValue("1");
		yearBox.selectByValue("2020");
	}

	// Temporary Method
	private void state() {
		Select stateBox = new Select(states);
		stateBox.selectByVisibleText("Alabama");
	}

}
