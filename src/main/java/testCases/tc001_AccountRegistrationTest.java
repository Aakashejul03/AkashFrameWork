package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;
import pageObjects.AccountRegistractionPage;
import pageObjects.HomePage;

public class tc001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		logger.info("*** Starting TC001_AccountRegistrationTest ***");
		try 
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("*** Clicked on My Account link ***");
		hp.clickRegister();
		logger.info("*** Clicked on Register Link ***");
		
		AccountRegistractionPage regpage = new AccountRegistractionPage(driver);
		logger.info("*** Providing Customer Details ***");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
			
		regpage.SetPrivacyPolicy();
		regpage.ClickContinue();
		
		logger.info("*** Validating expected Message ***");
		String confmsg = regpage.getConfirmationMsg();
		if (confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC001_AccountRegistrationTest ***");
	}
}
