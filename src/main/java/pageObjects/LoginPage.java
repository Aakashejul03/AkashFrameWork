package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage (WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-email']")	WebElement txtEmailID;
@FindBy(xpath="//input[@id='input-password']")	WebElement txtPassword;
@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;


	public void setEmail(String email)
	{
		txtEmailID.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}

}
