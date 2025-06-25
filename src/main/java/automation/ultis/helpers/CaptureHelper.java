package automation.ultis.helpers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureHelper {
	SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	public void takeScreenShot(WebDriver driver, String testCaseName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			File theDir = new File("./screenShot/");
			if(!theDir.exists()) {
				theDir.mkdir();
			}
			
			FileHandler.copy(source, new File("./screenShot/" + testCaseName + "_" + date.format(new Date()) + ".png"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
