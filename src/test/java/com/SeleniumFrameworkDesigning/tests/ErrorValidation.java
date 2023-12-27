package com.SeleniumFrameworkDesigning.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.SeleniumFrameworkDesigning.PageObjects.LoginPage;
import com.SeleniumFrameworkDesigning.testComponents.BaseTest;



public class ErrorValidation extends BaseTest{
	
	
	@Test
	public void loginFail () throws InterruptedException {
		
		LoginPage loginpage = landingpage.makeAppointment();
		loginpage.loginApplication("John Doe","ThisIsNotAPasswo");
		Assert.assertEquals("Login failed! Please ensure the username and password are valid.",loginpage.errorMessage());	
		
	}
	
	

	 

}
