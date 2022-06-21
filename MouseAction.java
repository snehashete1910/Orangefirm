package adminportal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseAction
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
@Test(priority=0,description="mouse over action move to element()")
public void action()
{
	Actions act=new Actions(driver);
	WebElement admin=driver.findElement(By.xpath("//a[@class='firstLevelMenu']"));
	WebElement managment=driver.findElement(By.id("menu_admin_UserManagement"));
	WebElement user=driver.findElement(By.id("menu_admin_viewSystemUsers"));
	///act.moveToElement(admin).build().perform();
	//act.moveToElement(managment).build().perform();//mouseover
	//act.moveToElement(user).click().build().perform();//mouseover to click
	act.moveToElement(admin).moveToElement(managment).moveToElement(user).click().build().perform();
}

@AfterClass
public void logout()
{
	driver.close();
}

}

