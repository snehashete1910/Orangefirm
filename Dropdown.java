package calendercontrol;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown<Webelement>
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
	public void main()
	{
		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b")).click();
		driver.findElement(By.id("menu_leave_viewLeaveList")).click();
		WebElement List=driver.findElement(By.name("leaveList[cmbSubunit]"));
		//System.out.println(List);
		Select se=new Select(List);
		@SuppressWarnings("unchecked")
		List<Webelement> list=(java.util.List<Webelement>) se.getOptions();
		System.out.println(list);
		driver.close();
	}

}
