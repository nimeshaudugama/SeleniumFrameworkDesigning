
package com.SeleniumFrameworkDesigning.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.SeleniumFrameworkDesigning.PageObjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializeDriver() throws IOException
	{
//		
		Properties prop = new Properties();
		FileInputStream  file = new FileInputStream (System.getProperty("user.dir")+"//src//main//java//com//SeleniumFrameworkDesigning//resources//GlobalData.properties");
		prop.load(file);
//		
		//String browserName = prop.getProperty("browser");
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") :prop.getProperty("browser");
//		
//	
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else {
//			System.setProperty("webdriver.gecko.driver", "");//initialize the firefox driver here 
//			driver = new FirefoxDriver();
//		}
		if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"//Users//nimesha//SeleniumProjects//geckodriver");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	
//	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
//		
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty(("user.dir")+ "//reports//" + testCaseName +".png"));
//		FileUtils.copyFile(source, file);
//		return System.getProperty("user.dir")+ "//reports//" + testCaseName +".png"; 
//		
//	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	
	public List<HashMap<String, Object>> getJsonDataToMap(String file ) throws IOException {
		
		// json to string
		String jsonContents = FileUtils.readFileToString(new File(file),
				StandardCharsets.UTF_8);
		
		//string to map  - Jackson databind
		
		ObjectMapper mapper = new ObjectMapper ();
		List<HashMap<String, Object>> data = mapper.readValue(jsonContents,new TypeReference<List<HashMap<String, Object>>>(){
			
		});
		return data;
		
		
	}
	
	@BeforeMethod()
	public LandingPage launchSite() throws IOException {
		
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		
		landingpage.goTo();
		return landingpage;
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}