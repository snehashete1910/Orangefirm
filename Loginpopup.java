package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginpopup {
	WebDriver driver;
	@Test
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://Admin:admin@opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		
	}

}
