package moon;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationObject extends PageObjectSuperClass {

	@FindBy(className="login")
	private WebElement loginButton;
	
	private String email;
	private Random rand;

	@FindBy(id="email_create")
	private WebElement createAccountEmailField;

	@FindBy(id="SubmitCreate")
	private WebElement createAccountButton;

	@FindBy(xpath="//*[@id='account-creation_form']/div[1]/h3")
	private WebElement personalInformationText;

	@FindBy(id="customer_firstname")
	private WebElement firstNameField;

	@FindBy(id="customer_lastname")
	private WebElement lastNameField;

	@FindBy(id="email")
	private WebElement emailField;

	@FindBy(id="passwd")
	private WebElement passwordField;

	@FindBy(id="firstname")
	private WebElement firstNameAddressField;

	@FindBy(id="lastname")
	private WebElement lastNameAddressField;

	@FindBy(id="days")
	private WebElement days;

	@FindBy(id="months")
	private WebElement months;

	@FindBy(id="years")
	private WebElement years;

	@FindBy(id="address1")
	private WebElement addressField;

	@FindBy(id="city")
	private WebElement cityField;

	@FindBy(id="id_state")
	private WebElement states;

	@FindBy(id="postcode")
	private WebElement zipField;

	@FindBy(id="phone_mobile")
	private WebElement phoneField;

	@FindBy(id="submitAccount")
	private WebElement registerButton;	

	@FindBy(xpath="//*[@id='center_column']/h1")
	private WebElement myAccountText;

	public AccountCreationObject(WebDriver driverInstance) {
		super(driverInstance);
		rand = new Random();
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
