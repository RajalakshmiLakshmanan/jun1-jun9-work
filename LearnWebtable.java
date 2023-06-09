package officeWork.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWebtable {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(option);
		driver.get("https://leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> element = driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/tr"));
        int size = element.size();
        for(int i=1;i<=size;i++) {
        	WebElement fcolumndata = driver.findElement(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/tr["+i+"]/td[1]"));
        	
        	System.out.println(fcolumndata.getText());
        	
        }
        List<WebElement> columnsize = driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/tr[1]/td"));
        int csize = columnsize.size();
        
        for(int i=1;i<=size;i++) {
        	for(int j=1;j<=csize;j++) {
        		WebElement tabledata = driver.findElement(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/tr["+i+"]/td["+j+"]"));
        		System.out.println(tabledata.getText()+"   ");
        		
        		
        
        	}
        	
        }
		
		
		
	}

}
