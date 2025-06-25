package automation.pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;
import automation.constants.CT_HomePage;

public class FindBepGasPage extends CommonBase{
	private  WebDriver driver;
	
	public FindBepGasPage(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void FindBepGaAm() {
		clickToElement(By.xpath(CT_HomePage.BEPGAS_LINK));
		clickToElement(By.xpath(CT_HomePage.BEPGAAM_LINK));
	}
}
