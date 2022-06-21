package calendercontrol;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender
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
	public void calender() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b")).click();//leve link
		driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[1]/img")).click();//leve page
		driver.findElement(By.className("ui-datepicker-trigger")).click(); //calender click
		Thread.sleep(2000);
		Select a=new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']")));//year select
		a.selectByVisibleText("2022");
		for(int i=4;i>=1;i++)
		{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			//driver.findElement(By.className("ui-icon ui-icon-circle-triangle-e")).click();
		//driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();//go to arrow
		String m=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).getText();//select month
		if(m.equals("Mar"))
		{
			driver.findElement(By.linkText("26")).click();
			break;
		}
		
		}
		driver.close();
	}

}
