package utils;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static reporting.ComplexReportFactory.closeReport;
import static reporting.ComplexReportFactory.closeTest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentTest;

public class WebTestBase {

	public static WebDriver driver;
	public ExtentTest test;
	public static Logger logger;
	public final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	@AfterSuite(alwaysRun = true)
	public void close() {
		closeReport();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");
		if (url == null) {
			url = prop.getProperty("url");
		}
		if (browser == null) {
			browser = "chrome";
		}
		System.out.println(url);
		driver = new Drivers().getWebDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@BeforeMethod()
	public void beforeMethod(Method method) {
		logger = Logger.getLogger(method.getDeclaringClass().getSimpleName() + "-" + method.getName());
//        test = getTest(method.getDeclaringClass().getSimpleName() + "-" + method.getName(), method.getName());
		System.out.println("Method Name - " + method.getDeclaringClass().getSimpleName() + "-" + method.getName());
		logger.debug("Test Case Started " + method);
	}

	@AfterMethod(alwaysRun = true)
	public void reportWrapUp(ITestResult result, Method method) {

		if (!result.isSuccess()) {

			String imagePath = System.getProperty("user.dir") + "\\reports\\" + method.getName() + "_"
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			// generate screenshot as a file object
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				// copy file object to designated location
				FileUtils.copyFile(scrFile, new File(imagePath + ".png"));
				System.out.println(imagePath + ".png");
				logger.info("Method - " + method.getName() + " failed , see the screenshot - " + imagePath + ".png");
			} catch (Exception e) {
				AssertJUnit.fail("Error while taking screenshot - " + e);
			}

		}
		closeTest(test);
	}

//   @AfterClass(alwaysRun = true)
// public void closeBrowser() {
//     driver.quit();
//   }
}
