package testcase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestSearchField {

	public WebDriver driver;
	
	@Test
	@Parameters({"url","value"})
	public void validateSearchField(String url,String value) throws InterruptedException {
		
		//This option is used to open browser in incognito mode
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		
        //Launch the browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		//Navigate to the url, maximize the window and wait for all the webelements till they load
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#search")).sendKeys(value);
		
		List<WebElement>list =driver.findElements(By.xpath("//div[@class='hd-mobile-suggest-container marginBottom-24']"));
		List listAscending = new ArrayList();
		Thread.sleep(3000);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			listAscending.add(list.get(i).getText());
			
		}
		
		System.out.println("***************");
		Collections.sort(listAscending);
		System.out.println("list in ascending order" +listAscending);
		
		
		
		
		
	}

}
