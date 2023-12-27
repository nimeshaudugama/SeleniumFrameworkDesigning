package com.SeleniumFrameworkDesigning.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SeleniumFrameworkDesigning.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="txt-username")
	WebElement username;
	
	//WebElement usename = driver.findElement(By.id("txt-username"));
	
	@FindBy(id = "txt-password")
	WebElement password;
	
	@FindBy(id = "btn-login")
	WebElement login;
	
	
	@FindBy(xpath = "//p[@class='lead text-danger']")
	WebElement  errorMessage;
	
	public BookAnAppointment loginApplication (String user,String psd) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(psd);
		login.click();
		System.out.println("Click on login");
//		Thread.sleep(5000);
		
	
		BookAnAppointment bookanappointment = new BookAnAppointment(driver);
		return bookanappointment;
	}
	
	 public String errorMessage()
		{
		  waitForElementToApper(By.xpath("//p[@class='lead text-danger']"));
			return errorMessage.getText();
		}

}
