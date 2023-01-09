package rough;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class roughbbc {
	public static WebDriver driver;
	
	
	@Test
	public void run()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options. addArguments("headless");
	driver=new ChromeDriver(options);
		driver.get("https://www.bbc.com");

		List<WebElement> title_list=driver.findElements(By.xpath("//section[@class='module module--news   module--collapse-images']//div[@class='media__content']//a[@class='media__link']"));
		List<WebElement> desc_list=driver.findElements(By.xpath("//section[@class='module module--news   module--collapse-images']//div[@class='media__content']//p"));
		for(WebElement w:title_list)
			System.out.println(w.getText());
		
		for(WebElement w:desc_list)
		{
		System.out.println(	w.getText());
		}
		Map<List<WebElement>,List<WebElement>> hmpa=new HashMap<List<WebElement>,List<WebElement>>();
	}

}
