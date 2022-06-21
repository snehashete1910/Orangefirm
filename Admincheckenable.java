package adminportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//goto burl--https://opensource-demo.orangehrmlive.com/
//goto AdminUsermanagement
//Check enable disable



public class Admincheckenable

{
WebDriver driver;

public void login() throws InterruptedException 
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(2000);
}
@Test
public void Enable() 
{
	driver.findElement(By.xpath("//a[@class='firstLevelMenu']")).click();
	driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement')")).click();
	driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers')")).click();

	// @SuppressWarnings("unchecked")
	int rowcount= driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[1]")).getText().codePointAt(0);
	System.out.println(rowcount);
	int statuscount=0;
	for(int i = 1;i <= rowcount;i++)
	{
		String status=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+ i+ "]/td[5]")).getText();
		if(status.equals("	Enabled"))
		{
			statuscount=statuscount+1;
		}
		System.out.println("Total no of employee"+statuscount);
		driver.quit();
	}
}
	
}

