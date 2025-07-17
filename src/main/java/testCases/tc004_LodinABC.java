package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class tc004_LodinABC extends BaseClass {
	
@Test()
public void verify_login()
{
	logger.info("*** Starting TC_004_LoginTest ***");
	
	try
	{
		logger.info("*** Home Page ***");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("*** Loggin Page ***");
		LoginPage lp = new LoginPage (driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();	
		
		MyAccount macc = new MyAccount(driver);
		boolean targetPage;
		if (targetPage = macc.isMyAccountPageExists())
		{
			macc.clickLogOut();
		}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("*** Finished Test Login TestCase ***");

	
}

}
