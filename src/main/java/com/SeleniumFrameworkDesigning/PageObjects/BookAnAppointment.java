package com.SeleniumFrameworkDesigning.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.SeleniumFrameworkDesigning.AbstractComponents.AbstractComponents;



public class BookAnAppointment extends AbstractComponents{
	
	
	WebDriver driver;

	public BookAnAppointment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		
	}
	@FindBy(xpath = "//div[@class='col-sm-4']//select")
	WebElement facility;
	
//	@FindBy(className = "col-sm-4")
//	WebElement program;
//	
//	List<WebElement> selectProgram = program.findElements(By.className("radio-inline"));
//	
	@FindBy(xpath = "//input[@class = 'form-control']")
	WebElement date;
	
	@FindBy(id="btn-book-appointment")
	WebElement bookBtn;
	
	//@FindBy()
	
	
	
	
	public ConfirmationPage makeTheBooking(int index,int programName,String calenderDate)
	
	{
		
		System.out.println("Appointment page");
		
		waitForElementToApper(By.xpath("//div[@class='col-sm-4']//select"));
		
		Select select = new Select (facility);
		select.selectByIndex(index);
		
		waitForElementToApper(By.className("radio-inline"));

	    // Re-fetch the program WebElement to avoid "null" issue
	    WebElement programElement = driver.findElement(By.xpath("//div[@class='col-sm-4']"));
	    List<WebElement> selectProgram = programElement.findElements(By.xpath("//label[@class='radio-inline']//input"));
		
		//waitForElementToApper(By.className("radio-inline"));
		selectProgram.get(programName).click();
		
		waitForElementToApper(By.xpath("//input[@class = 'form-control']"));
		date.sendKeys(calenderDate);
		
		waitForElementToApper(By.id("btn-book-appointment"));
		bookBtn.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
		
		
	}	
	
	

}
