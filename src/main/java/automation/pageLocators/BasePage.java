package automation.pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class BasePage extends CommonBase{
	public static WebDriver driver;
	private String ele_lbl_AnyProduct = "//div[@class = 'relative group']/following-sibling::ul//a[normalize-space()= '%s']";
	private String ele_lbl_AnyCategory = "//h3[text() = 'Danh mục']/following-sibling::div//a[text() ='%s']";
	public BasePage (WebDriver _driver) {
		this.driver = _driver;
	}
	public BasePage SelectProduct(String productName) {
		clickToElement(By.xpath(String.format(productName, ele_lbl_AnyProduct)));
		return this;
	}
	public BasePage FilterProductByCategory() {
		clickToElement(By.xpath(ele_lbl_AnyCategory));
		return this;
	}
}
