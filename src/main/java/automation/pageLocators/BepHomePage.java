package automation.pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;
import automation.constants.CT_HomePage;
import automation.ultis.logs.Log;

public class BepHomePage extends CommonBase{
	private WebDriver driver;
	
	public BepHomePage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	public void OrderBepTuProd(String nameProd, String brandName) {
		String xpath_menu = String.format(CT_HomePage.MENU_LINK, nameProd);
		String xpath_brand = String.format(CT_HomePage.BEPTU_BRAND_NAME, brandName.toLowerCase());
		Log.info("click on Bếp Từ");
		
		clickToElement(By.xpath(xpath_menu));
		Log.info("click on bosch prod");
		clickToElement(By.xpath(xpath_brand));
		Log.info("Hover first prod");
		scroolToBottom();
		hoverToElement(By.xpath(CT_HomePage.FIRST_PROD));
		Log.info("Click first prod");
		clickToElement(By.xpath(CT_HomePage.FIRST_PROD));
		Log.info("Click on Mua Ngay");
		pause(3000);
		clickToElementByJSExecutor(By.xpath(CT_HomePage.BUY_NOW_BTN));
		pause(3000);
	}
	
	public void findProduct(String nameProd) {
		String xpath = String.format(CT_HomePage.MENU_LINK, nameProd);
		clickToElement(By.xpath(xpath));
		pause(2000);
	}
	public void findBrandName_MayRuaBat(String brandName) {
		String xpath = String.format(CT_HomePage.MAYRUACHENBAT_BRAND_NAME, brandName);
		clickToElement(By.xpath(xpath));
		pause(2000);
	}
	public void findProdPrice (String price) {
		String xpath = String.format(CT_HomePage.PROD_PRICE, price);
		clickToElement(By.xpath(xpath));
		pause(2000);
	}
	public void findCountry(String country) {
		String xpath = String.format(CT_HomePage.COUNTRY_NAME, country);
		clickToElement(By.xpath(xpath));
		pause(2000);
	}
	public void findSoBo() {
		
	}
	public void FillInforOnOrderAndPay(String name, String phone, String address) {
		Log.info("Fill name");
		sendTextToElement(By.xpath(CT_HomePage.NAME_INPUT), name);
		Log.info("Fill phone");
		sendTextToElement(By.xpath(CT_HomePage.PHONE_INPUT), phone);
		Log.info("Fill address");
		sendTextToElement(By.xpath(CT_HomePage.ADDRESS_INPUT), address);
		Log.info("Click pay button");
		clickToElement(By.xpath(CT_HomePage.PAY_BTN));
		pause(3000);
	}
	
	public void findAllBepGaProds() {
		Log.info("click on Bep Gas");
		clickToElement(By.xpath(CT_HomePage.BEPGAS_LINK));
		Log.info("click on Bep Gas Am");
		clickToElement(By.xpath(CT_HomePage.BEPGAAM_LINK));
		pause(3000);
	}

}
