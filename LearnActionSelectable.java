package officeWork.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnActionSelectable {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement box2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement box3 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement box4 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		Actions mulsel = new Actions(driver);
		mulsel.keyDown(Keys.CONTROL).click(box1).click(box2).click(box3).click(box4).keyUp(Keys.CONTROL).perform();
         driver.close();
	}

}
