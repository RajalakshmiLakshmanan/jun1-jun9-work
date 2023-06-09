package officeWork.practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnXpath {

	public static void main(String[] args) throws IOException {

      ChromeOptions option = new ChromeOptions();
      option.addArguments("--remote-allow-origins=*");
      ChromeDriver driver = new ChromeDriver(option);
      
      driver.get("https://www.chittorgarh.com/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
      driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
      driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
      
      List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr"));
      int rsize = list.size();
      System.out.println(rsize);
      Set<String> set = new HashSet<String>();
      //to retrive the first column data
      for(int i=1;i<rsize;i++) {
    	  
    	  WebElement element = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr["+i+"]/td/a"));
    	  System.out.println(element.getText()); 
    	  set.add(element.getText());
    	  
      }
      System.out.println(set.size());
	  if(rsize!=set.size()) {
		  
		  System.out.println("Its verified that  there is no duplicate");
	  }
		
	  // to retrive the Ist row elements
	  
	  List<WebElement> list2 = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr[1]/td"));
	  System.out.println("column size:"+list2.size());
	  
	  for(int i=2;i<=list2.size();i++) {
		  WebElement element = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr[1]/td["+i+"]"));
		  System.out.println(element.getText());
		  
	  }
	  File file = driver.getScreenshotAs(OutputType.FILE);
      File des = new File("./snap/stock.png");
      FileUtils.copyFile(file, des);
	  
		
	}

}
