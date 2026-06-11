package PrimeVideo.minidetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	public HomePage homePage;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement signInButton;

	public HomePage logIn(String eMail, String passWord) {
		email.sendKeys(eMail);
		password.sendKeys(passWord);
		signInButton.click();
		homePage = new HomePage(driver);
		return homePage;

	}

}
