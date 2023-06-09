package qadex;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseClass {
	public ChromeDriver driver;
	
	@BeforeMethod
	public void runPrecondition() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("remote-allow-origins=*");
		 driver =new ChromeDriver(option);
		
		driver.get("https://naf.qadex.com/user/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("membership")).sendKeys("QM54439 ");
		driver.findElement(By.id("firstuserid")).sendKeys("QU71003");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
		
	}
	@AfterMethod
	public void runPostCondition() {
		driver.close();
		
	}
	@DataProvider
	public String[][] setData() throws IOException {
		return ReadExcel.readData();
		
	}
	

}
