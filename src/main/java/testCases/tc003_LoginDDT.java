package testCases;

import org.testng.Assert;

import testBase.BaseClass;
import utilities.DataProviders;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class tc003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData1", dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("*** Starting Logging Validation ***");
		try
		{
		//HomePage
			logger.info("*** Home Page ***");
		HomePage hp = new HomePage(driver);
		logger.info("On Home Page");
		hp.clickMyAccount();
		logger.info("Clicked My Account");
		hp.clickLogin();
		logger.info("Clicked My Login");
		
		//Login
		logger.info("*** Login Page ***");
		LoginPage lp = new LoginPage(driver);
		logger.info("Setting email");
		lp.setEmail(email);
		logger.info(email);
		lp.setPassword(pwd);
		logger.info(pwd);
		lp.clickLogin();
		logger.info("Clicked Login");
		
		//MyAccount
		logger.info("*** My Account Page ***");
		MyAccount macc = new MyAccount(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
			logger.info("*** Valid Data ***");
		{
			if(targetPage==true)
			{
				logger.info("*** Clicking Logout ***");
				macc.clickLogOut();
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Invalid Data Did not logged in");
				Assert.assertTrue(false);
			}
		}
		
		//if(exp.equalsIgnoreCase("Invalid"))
			//logger.info("*** InValid Data ***");
		//{
			//if(targetPage==true)
			//{
			//	macc.clickLogOut();
			//	Assert.assertTrue(false);
			//}
			//else
			//{
			//	Assert.assertTrue(true);
			//}
		//}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Ending Loggin Validation ***");
		
	}

}
