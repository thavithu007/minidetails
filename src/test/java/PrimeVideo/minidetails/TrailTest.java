package PrimeVideo.minidetails;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PrimeVideo.minidetails.testdata.TestData;

public class TrailTest extends TestData {
	/*@Test(dataProvider = "getData1")
	public void TC1(HashMap<String, String> input) {
		HomePage homePage = landingPage.logIn(input.get("email"), input.get("password"));
		homePage.addProductByName(input.get("productName"));
		CartPage cartPage = homePage.goToCart();
		boolean match = cartPage.checkProductInCart(input.get("productName"));
		Assert.assertTrue(match);
	}*/
	@Test(dataProvider = "getData2")
	public void TC2(HashMap<String, String> input) {
		HomePage homePage = landingPage.logIn(input.get("email"), input.get("password"));
		homePage.addProductByName(input.get("productName"));
		CartPage cartPage = homePage.goToCart();
		boolean match = cartPage.checkProductInCart(input.get("productName"));
		Assert.assertTrue(match);
	}

	/*
	 * @DataProvider public Object[][] getData(){ return new Object[][]
	 * {{"thavithu15@gmail.com","10011998Ad@","ZARA COAT 3"},{"thavithu15@gmail.com"
	 * ,"10011998Ad@","ADIDAS ORIGINAL"}}; }
	 */
	@DataProvider
	public Object[][] getData1() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "thavithu15@gmail.com");
		map1.put("password", "10011998Ad");
		map1.put("productName", "ZARA COAT 3");
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("email", "thavithu15@gmail.com");
		map2.put("password", "10011998Ad");
		map2.put("productName", "ADIDAS ORIGINAL");
		return new Object[][] { { map1 }, { map2 } };

	}

	@DataProvider
	public Object[][] getData2() throws IOException{
		List<HashMap<String,String>> data=getJsonToMap("C:\\Users\\Vijayalakshmi\\democicd\\minidetails\\src\\test\\java\\PrimeVideo\\minidetails\\JsonDataProvider\\data.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
	}

}
