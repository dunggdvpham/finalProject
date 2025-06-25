package automation.common;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonBase {
	public static WebDriver driver;
	public int initTime = 30;
	
	// create browser
	public WebDriver initChromeBrowser() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-software-rasterizer");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(initTime));
		return driver;
	}
	public WebDriver initChromeBrowser(String url) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-software-rasterizer");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(initTime));
		return driver;
	}
	
	public WebDriver initFirefoxBrowser() {
		WebDriverManager.firefoxdriver().clearDriverCache().setup();
		driver = new FirefoxDriver();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-software-rasterizer");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(initTime));
		return driver;
	}
	
	public WebDriver initEdgeBrowser() {
		WebDriverManager.edgedriver().clearDriverCache().setup();
		driver = new EdgeDriver();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-software-rasterizer");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(initTime));
		return driver;
	}
	
	public WebDriver setupDriver(String browserName) {
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = initChromeBrowser();
			break;
		case "firefox":
			driver = initFirefoxBrowser();
			break;
		case "edge":
			driver = initEdgeBrowser();
			break;
		default:
			System.out.println("Not found browser, switch to default Chrome browser!");
			driver = initChromeBrowser();
			break;
		}
		return driver;
	}
	
	//common method
	
	public WebElement getElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public WebElement getElementPresentInDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initTime));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public List<WebElement> getAllElementVisibility(By locator) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initTime));
	        
	        // Wait until all elements are visible
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	        
	        // Return the found elements
	        return driver.findElements(locator);
	    } catch (TimeoutException e) {
	        System.out.println("Timeout waiting for elements to become visible: " + locator);
	        return new ArrayList<>(); // Return an empty list if timeout occurs
	    } catch (Exception e) {
	        System.out.println("Error occurred while finding elements: " + e.getMessage());
	        return new ArrayList<>(); // Return an empty list for any other errors
	    }
	}
	
	public boolean isVisibility(By locator) {
		WebElement element = getElementVisibility(locator);
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e1) {
			// TODO: handle exception
			return false;
		}catch (TimeoutException e2) {
			// TODO: handle exception
			return false;
		}
 	}
	
	public void clickToElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initTime));
		
		WebElement element = getElementVisibility(locator);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void sendTextToElement(By locator, String key) {
		WebElement element = getElementVisibility(locator);
		element.clear();
		element.sendKeys(key);
	}
	
	public void clickToElementByJSExecutor(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getElementPresentInDOM(locator));
	}
	
	public void hoverToElement(By locator) {
		WebElement element = getElementVisibility(locator);
		Actions atc = new Actions(driver);
		atc.moveToElement(element);
	}
	
	public void scrollToElement(By locator) {
		WebElement element = getElementVisibility(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scroolToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		pause(2000);
	}
	public void pause(long miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	public void verifyDisplay(By locator) {
		 assertTrue(getElementVisibility(locator).isDisplayed());
	}
	public void sleepInSeconds(long milisecond) {
		try {
			Thread.sleep(milisecond*1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
