package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabMenuPage {
	
	@FindBy(xpath = "//a[text()='Logout']") private WebElement Logout;
	
	public SwaglabMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSwaglabMenuPageLogout()
	{
		Logout.click();
	}
	
	

}
