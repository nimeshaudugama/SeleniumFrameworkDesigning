package com.SeleniumFrameworkDesigning.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SeleniumFrameworkDesigning.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
				
		
	}
	
	
	@FindBy(xpath = "//p[@class='lead']")
	WebElement confirmation;
	
	@FindBy(xpath = "//p[@id='facility']")
	WebElement facility;
	
	@FindBy(xpath="//p[@id='program']")
	WebElement program;
	
	
	
	public String confirmation () {
		String confirmationMessage = confirmation.getText();
//		String facilityField = facility.getText();
//		String programField = program.getText();
//		String[] confirmationDetails =  {confirmationMessage,facilityField,programField};
		 return confirmationMessage;
		
	}

	
	

}
