package com.SeleniumFrameworkDesigning.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SeleniumFrameworkDesigning.PageObjects.BookAnAppointment;
import com.SeleniumFrameworkDesigning.PageObjects.ConfirmationPage;
import com.SeleniumFrameworkDesigning.PageObjects.LoginPage;
import com.SeleniumFrameworkDesigning.testComponents.BaseTest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;





public class MakeTheBookingTest extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void  makeBooking(HashMap<String,Object> input) throws InterruptedException {
	LoginPage loginpage = landingpage.makeAppointment();
	BookAnAppointment bookanappointment = loginpage.loginApplication((String)input.get("username"),(String)input.get("password"));
	ConfirmationPage confirmationpage = bookanappointment.makeTheBooking((int)input.get("facility"),(int)input.get("program"),(String)input.get("date"));
	
	String confirmationDetails = confirmationpage.confirmation();
	Assert.assertTrue(confirmationDetails.contains("Please be informed that your appointment has been booked as"));
	
//	Assert.assertTrue(confirmationDetails[1].contains(""));


	
	}
	
	@DataProvider
	public Object[][] getData () throws IOException {
		
	List<HashMap<String, Object>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//com//SeleniumFrameworkDesigning//data//MakeAppointment.json");
	return new Object [][] {{data.get(0)},{data.get(1)}};
			
	}
	
	
	
	

}
