package com.SeleniumFrameworkDesigning.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;



public class LandingPage {

	WebDriver driver;
	
	public LandingPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		}
	
	//WebElement makeAppointment = driver.findElement(By.id("btn-make-appointment")); 
	
	
	 @FindBy(id = "btn-make-appointment")
	 WebElement makeAppointment;
	
	 public LoginPage makeAppointment() {
		 
		 makeAppointment.click();
		 LoginPage loginpage = new LoginPage(driver);
		 return loginpage;
	 }
	 
	 
	 
	 
	 
	 public void goTo () {
		 driver.get("https://katalon-demo-cura.herokuapp.com/");
	 }
	
	
}
