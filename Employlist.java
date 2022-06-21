package adminportal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Employlist 
{
	
WebDriver driver;
@SuppressWarnings("deprecation")
@BeforeClass
public void Login() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(2000);
}
@Test
public void Employeelist()
{
	driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	//int rowcount=driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_59\"]")).getText().codePointAt(0);
	int rowcount=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[5]/td[3]")).getText().codePointAt(0);;
	int statuscount=0;
	for(int i=0;i<=rowcount;i++)
	{
		//driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_"+i+"\"]")).click();
		for(int j=0;j<=rowcount;j++)
		{
			driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]/td["+j+"]")).click();
			{
				statuscount=statuscount+1;
			}
	
		
		driver.quit();
	}
}
	}

}