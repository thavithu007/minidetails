package PrimeVideo.minidetails.Abstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PrimeVideo.minidetails.CartPage;

public class AbstractMethods {
	WebDriver driver;
	
	
	public AbstractMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartButton;

	public void waitTillAppear(By waitElement) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
		}
	
	public void waitTillDisappear(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public CartPage goToCart() {
		cartButton.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}

}
