package officeWork.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://leafground.com/window.xhtml");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		
		List<String> handle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handle.get(1));
		
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(handle.get(0));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> set = driver.getWindowHandles();
		System.out.println(set.size());
		List<String> list1 = new ArrayList<String>(set);
		driver.switchTo().window(list1.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list1.get(1));
		driver.close();
		driver.switchTo().window(list1.get(0));
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> set2 = driver.getWindowHandles();
		System.out.println(set2.size());
		List<String> list2 = new ArrayList<String>(set2);
		driver.switchTo().window(list2.get(1));
		driver.close();
		driver.switchTo().window(list2.get(2));
		driver.close();
		driver.switchTo().window(list2.get(3));
		driver.close();
		
		driver.switchTo().window(list2.get(0));
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> set3 = driver.getWindowHandles();
		System.out.println(set3.size());
		
		List<String> list3 = new ArrayList<String>(set3);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(set3.size()));
		
		driver.switchTo().window(list3.get(1));
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
		
	}

}
