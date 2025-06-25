package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import automation.common.CommonBase;
import automation.constants.CT_HomePage;
import automation.constants.CT_pageURL;
import automation.pageLocators.BepHomePage;
import automation.ultis.helpers.CaptureHelper;
import automation.ultis.listeners.ReportListener;
import automation.ultis.logs.Log;

@Listeners(ReportListener.class)
public class TestHomePage extends CommonBase{

	@Parameters("browserTestNG")
	@BeforeMethod
	public void openBrowser(@Optional String browserTestNG) {
		setupDriver(browserTestNG);
		driver.get(CT_pageURL.PAGE_URL);
	}
	@AfterMethod
	public void quitBrowser(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus() || ITestResult.SKIP == result.getStatus()) {
			CaptureHelper capture = new CaptureHelper();
			capture.takeScreenShot(driver, result.getName());
		}
		driver.quit();
	}
	@Test (priority = 1)
	public void placeOrderWithoutInfo_BepTu() {
		BepHomePage bep = new BepHomePage(driver);
		bep.OrderBepTuProd("Bếp Từ", "bosch");
		bep.FillInforOnOrderAndPay("", "", "");
		assertTrue(isVisibility(By.xpath(CT_HomePage.NAME_ERROR)));
		assertTrue(isVisibility(By.xpath(CT_HomePage.PHONE_ERROR)));
		assertTrue(isVisibility(By.xpath(CT_HomePage.ADDRESS_INPUT)));
	}
	@Test (priority = 2)
	public void placeOrderWithoutPhoneAndAdress() {
		BepHomePage bep = new BepHomePage(driver);
		bep.OrderBepTuProd("Bếp Từ", "bosch");
		bep.FillInforOnOrderAndPay("Pham Do Viet Dung", "", "");
		assertTrue(isVisibility(By.xpath(CT_HomePage.PHONE_ERROR)));
		assertTrue(isVisibility(By.xpath(CT_HomePage.ADDRESS_INPUT)));
	}
	
	@Test (priority = 3)
	public void placeOrderWithoutName() {
		BepHomePage bep = new BepHomePage(driver);
		bep.OrderBepTuProd("Bếp Từ", "bosch");
		bep.FillInforOnOrderAndPay("", "0346334242", "Đại Linh, Nam Từ Liêm, Hà Nội");
		assertTrue(isVisibility(By.xpath(CT_HomePage.NAME_ERROR)));
		
	}
	
	@Test (priority = 4)
	public void placeOrderWithoutPhone() {
		BepHomePage bep = new BepHomePage(driver);
		bep.OrderBepTuProd("Bếp Từ", "bosch");
		bep.FillInforOnOrderAndPay("Pham Do Viet Dung", "", "Đại Linh, Nam Từ Liêm, Hà Nội");
		assertTrue(isVisibility(By.xpath(CT_HomePage.PHONE_ERROR)));
		
	}
	
	@Test (priority = 5)
	public void placeOrderWithWrongPhone() {
		BepHomePage bep = new BepHomePage(driver);
		bep.OrderBepTuProd("Bếp Từ", "bosch");
		bep.FillInforOnOrderAndPay("Pham Do Viet Dung", "+19003465812ad", "");
		assertTrue(isVisibility(By.xpath(CT_HomePage.PHONE_ERROR)));
		
	}
	

}
