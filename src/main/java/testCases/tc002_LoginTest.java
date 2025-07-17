package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;


public class tc002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() 
	{
		logger.info("*** Starting TC_002_LoginTest ***");
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccount
			MyAccount macc = new MyAccount(driver);
			boolean targetPage = macc.isMyAccountPageExists();
					
			Assert.assertTrue(targetPage);
			macc.clickLogOut();
			
		}
		catch(Exception e)
		{ 
			Assert.fail();
		}
		logger.info("*** Finished Test Login TestCase ***");
		
		//Logout
            
	}
	
	
	

}
