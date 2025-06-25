package automation.testsuite;

import org.testng.ITestResult;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constants.CT_pageURL;
import automation.pageLocators.BepHomePage;
import automation.ultis.helpers.CaptureHelper;

public class FindMayRuaChenBat extends CommonBase{
	@BeforeMethod
	public void openBrowser(@Optional String browserTestNG) {
		driver = initChromeBrowser();
		driver.get(CT_pageURL.PAGE_URL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus() || ITestResult.SKIP == result.getStatus()) {
			CaptureHelper capture = new CaptureHelper();
			capture.takeScreenShot(driver, result.getName());
		}
		sleepInSeconds(3);
		driver.quit();
	}
	@Test (priority = 1)
	public void findMayRuaBat_brandName_bosch() {
		BepHomePage home = new BepHomePage(driver);
		home.findProduct("Máy Rửa Chén Bát");
		home.findBrandName_MayRuaBat("bosch");
		home.findProdPrice("5.000.000 > 10.000.00"); // 3.000.000 > 5.000.000 , 5.000.000 > 10.000.000 , 10.000.000 > 15.000.000 , > 15.000.000
		home.findCountry("England");
	}
	@Test (priority = 2)
	public void findMayRuaBat_price_3to5() {
		BepHomePage home = new BepHomePage(driver);
		home.findProduct("Máy Rửa Chén Bát");
		home.findProdPrice("3.000.000 > 5.000.000"); // 3.000.000 > 5.000.000 , 5.000.000 > 10.000.000 , 10.000.000 > 15.000.000 , > 15.000.000
	}
	
	@Test (priority = 3)
	public void findMayRuaBat_madeBy_England() {
		BepHomePage home = new BepHomePage(driver);
		scroolToBottom();
		home.findProduct("Máy Rửa Chén Bát");
		home.findCountry("England");
	}
	

}
