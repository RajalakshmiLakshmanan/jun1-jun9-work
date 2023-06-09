package officeWork.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnClickandHold {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		
		int x = item4.getLocation().getX();
		int y = item4.getLocation().getY();
		
		Thread.sleep(2000);
		Actions cl = new Actions(driver);
		cl.clickAndHold(item1).dragAndDropBy(item4, x, y).perform();
		
		

	}

}
