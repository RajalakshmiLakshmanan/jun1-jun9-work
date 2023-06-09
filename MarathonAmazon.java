package officeWork;
//Testcase 3 (Amazon)
//===============
//01) Launch Chome  add  implicitlyWait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//02) Load https://www.amazon.in/
//03) Type "Bags" in the Search box
//04) Choose the 	 item in the result (bags for boys)
//05) Print the total number of results (like 40000)
//    1-48 of over 40,000 results for "bags for boys"
//06) Select the first 2 brands in the left menu
//    (like American Tourister, Generic)
//07) Choose New Arrivals (Sort)
//08) Print the first resulting bag info (name, discounted price)
//09) Get the page title and close the browser(driver.close())

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MarathonAmazon {
	

	public static void main(String[] args) {
	     ChromeOptions option = new ChromeOptions();
	     option.addArguments("--remote-allow-origins=*");
	     option.addArguments("--disable-notifications");
	     ChromeDriver driver = new ChromeDriver(option);
	     driver.get("https://www.amazon.in/");
	     
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     
	     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
	     driver.findElement(By.xpath("//span[text()=' for boys']")).click();
	     WebElement element = driver.findElement(By.xpath("//span[text()='1-48 of over 50,000 results for']"));
	     
	     System.out.println(element.getText());
	     //driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base a-text-bold'])[2]")).click();
	     //driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base a-text-bold'])[3]")).click();
	     driver.findElement(By.xpath("//li[@aria-label='American Tourister']")).click();
	     driver.findElement(By.xpath("//li[@aria-label='Zipline']")).click();
	     driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
	     driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
	     
	     WebElement element2 = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
	     System.out.println(element2.getText());
	     WebElement element3 = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
	     
	     System.out.println(element3.getText());
	     System.out.println(driver.getTitle());
	     driver.close();
	     
	     
	     
	     
	     
	     
	     

	}

}
