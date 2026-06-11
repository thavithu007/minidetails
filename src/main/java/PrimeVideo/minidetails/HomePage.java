package PrimeVideo.minidetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PrimeVideo.minidetails.Abstract.AbstractMethods;

public class HomePage extends AbstractMethods {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
    WebElement spinner;
	
By addToCart=By.cssSelector(".w-10");
By waitElement=By.cssSelector("#toast-container");

	
	public void addProductByName(String productName) {
		WebElement prod=products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().
				contains(productName)).findFirst().orElse(null);
		prod.findElement(addToCart).click();
		waitTillAppear(waitElement);
		waitTillDisappear(spinner);
		}
	

}
