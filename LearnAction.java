package officeWork.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class LearnAction {

	public static void main(String[] args) {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(option);
	driver.get("https://jqueryui.com/draggable/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 driver.switchTo().frame(0);
	 WebElement drag = driver.findElement(By.id("draggable"));
	 Actions action = new Actions(driver);
	action.dragAndDropBy(drag, 200,300).perform();

	}

}
