package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiplecredentials {
	@Test(dataProvider= "credentials")
	public void logincredential(String scenario,String username,String password) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
	
	if(scenario.equals("bothincorrect"))
	{
		String incorrect=driver.findElement(By.id("spanMessage")).getText();
		Assert.assertTrue(true, incorrect);
		System.out.println("invalid login credentials");
	}
	else if(scenario.equals("usernamecorrect"))
	{
		String incorrect1=driver.findElement(By.id("spanMessage")).getText();
		Assert.assertTrue(true, incorrect1);
	}
	else if(scenario.equals("passwordcorrect"))
	{
		String incorrect2=driver.findElement(By.id("spanMessage")).getText();
		Assert.assertTrue(true, incorrect2);
	}
	else if(scenario.equals("blank"))
	{
		String blank=driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(true, true);
		System.out.println(blank);
	}
	else
	{
		WebElement dashboard=driver.findElement(By.id("menu_dashboard_index"));
		Assert.assertTrue(dashboard.isDisplayed(), "dashboradopen");
	}
	
	driver.quit();
}

	@DataProvider(name ="credentials")
	public Object[][]getdata()
	{
		return new Object[][]
				{
			{"bothincorrect","sneha","sneha123"},
			{"usernamecorrect","Admin","sneha123"},
			{"passwordcorrect","sneha","admin123"},
			{"blank","",""},
			{"bothcorrect","Admin","admin123"}
			
				};
			
	}

}
