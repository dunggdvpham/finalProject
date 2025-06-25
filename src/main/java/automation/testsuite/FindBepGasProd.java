package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constants.CT_HomePage;
import automation.constants.CT_pageURL;
import automation.pageLocators.FindBepGasPage;
import automation.ultis.helpers.CaptureHelper;

public class FindBepGasProd extends CommonBase{
	@Parameters ("browserTestNG")
	@BeforeMethod
	public void openBrowser(@Optional String browserTestNG) {
		driver = initChromeBrowser();
		driver.get(CT_pageURL.PAGE_URL);
	}
	@AfterMethod 
	public void closeBrowser(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus() || ITestResult.SKIP == result.getStatus()) {
			CaptureHelper cap = new CaptureHelper();
			cap.takeScreenShot(driver, result.getName());
		}
		sleepInSeconds(3);
		driver.quit();
	}
	
	@Test
	public void FindProd() {
		FindBepGasPage bepGas = new FindBepGasPage(driver);
		bepGas.FindBepGaAm();
		scroolToBottom();
		List<WebElement> allBepGaAmProd = getAllElementVisibility(By.xpath(CT_HomePage.PROD_LIST));
		for (WebElement bepGasProd : allBepGaAmProd) {
			System.out.println(bepGasProd.getText().trim().toLowerCase());
			assertTrue(bepGasProd.getText().trim().toLowerCase().contains("bếp") || bepGasProd.getText().trim().toLowerCase().contains("bếp ga") || bepGasProd.getText().trim().toLowerCase().contains("bếp gas âm"));
		}
		
	}
	@Test
	public void FindProEngland() {
		FindBepGasPage bepGas = new FindBepGasPage(driver);
		bepGas.FindBepGaAm();
		scroolToBottom();
		clickToElement(By.id(CT_HomePage.ENG_COUNTRY));
		
		clickToElement(By.xpath(CT_HomePage.ENG_PROD));
		System.out.println(getElementVisibility(By.xpath(CT_HomePage.MADE_BY)).getText().trim().toLowerCase());
		assertTrue(getElementVisibility(By.xpath(CT_HomePage.MADE_BY)).getText().trim().toLowerCase().contains("england"));
		
	}
	

}
