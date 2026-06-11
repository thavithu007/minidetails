package PrimeVideo.minidetails;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PrimeVideo.minidetails.Abstract.AbstractMethods;

public class CartPage extends AbstractMethods {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(css="div.cartSection h3")
	List<WebElement> cartProducts;
	
	public boolean checkProductInCart(String productName) {
		
		boolean match=cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
		return match;
		}

}
