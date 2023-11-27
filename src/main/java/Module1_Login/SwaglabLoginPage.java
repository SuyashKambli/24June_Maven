package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabLoginPage {
	
	@FindBy(xpath = "//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath = "//input[@id='password']") private WebElement PWD;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement Login;
	
	public SwaglabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpSwaglabLoginpageUN(String username)
	{
		UN.sendKeys(username);
	}
	
	public void inpSwaglabLoginpagePWD(String password)
	{
		PWD.sendKeys(password);
	}
	
	public void clickSwaglabLoginpageBtn()
	{
		Login.click();
	}

}
