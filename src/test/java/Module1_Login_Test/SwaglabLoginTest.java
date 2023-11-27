package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilityClass;
import Module1_Login.SwaglabHomePage;
import Module1_Login.SwaglabLoginPage;
import Module1_Login.SwaglabMenuPage;

public class SwaglabLoginTest extends BaseClass 
{	
	SwaglabLoginPage login;	
	SwaglabHomePage home;
	SwaglabMenuPage menu;
	int TCID;
	
	@BeforeClass
	public void OpenBrowser() throws IOException
	{
		initializeBrowser();
		login=new SwaglabLoginPage(driver);
		home=new SwaglabHomePage(driver);
		menu=new SwaglabMenuPage(driver);
	}
	
	@BeforeMethod
	public void LoginToApp() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.inpSwaglabLoginpageUN(UtilityClass.getDataFromPF("UN"));
		Thread.sleep(3000);
		login.inpSwaglabLoginpagePWD(UtilityClass.getDataFromPF("PWD"));
		Thread.sleep(3000);
		login.clickSwaglabLoginpageBtn();
		Thread.sleep(3000);
	}
	
	@Test
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{
		TCID=101;
		String actTitle=home.getSwaglabHomePageTitle();
		String expTitle=UtilityClass.getTD(0, 2);
		Assert.assertEquals(actTitle, expTitle,"Both results are failed");
	}
	
	@AfterMethod
	public void LogoutToApp(ITestResult s) throws InterruptedException, IOException
	{
		if(s.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}
		home.clickSwaglabHomePageMenu();
		Thread.sleep(3000);
		menu.clickSwaglabMenuPageLogout();
	
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
	}

}
