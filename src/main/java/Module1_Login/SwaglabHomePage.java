package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabHomePage {
@FindBy(xpath = "//button[text()='Open Menu']") private WebElement Menu;

WebDriver driver;

	public SwaglabHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSwaglabHomePageMenu()
	{
		Menu.click();
	}
	
	public String getSwaglabHomePageTitle()
	{
		String actTitle= driver.getTitle();
		return actTitle;
	}
	

}
