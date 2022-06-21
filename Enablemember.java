package adminportal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Enablemember {

public class Admincheckenable

{
WebDriver driver;
@SuppressWarnings("deprecation")
@BeforeClass
public void login() throws InterruptedException 
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(2000);
}
@Test
public void Enable() throws InterruptedException 
{
	driver.findElement(By.xpath("//a[@class='firstLevelMenu']")).click();
	driver.findElement(By.id("menu_admin_UserManagement")).click();
	driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
	//driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement')")).click();
	//driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers')")).click();

	// @SuppressWarnings("unchecked")
	int rowcount= driver.findElement(By.xpath("//*//*[@id=\"resultTable\"]/tbody/tr[4]/td[1]")).getText().codePointAt(0);
	System.out.println(rowcount);
	int statuscount = 0;
	for(int i = 1;i <= rowcount;i++)
	{
		String status=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+ "]/td[s5]")).getText();
		
		if(status.equals("Enabled"))
		{
			statuscount=statuscount+1;
			//statuscount++;
			//System.out.println("Total no of employee:" +statuscount);
		}
		Thread.sleep(2000);
		System.out.println("Total no of employee:" +statuscount);
		Thread.sleep(2000);
		//driver.close();
		driver.quit();
	}
}
	
}



}
