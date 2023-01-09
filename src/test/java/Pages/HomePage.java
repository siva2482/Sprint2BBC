package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.TestBase;

public class HomePage extends TestBase {
	
	//public static  WebDriver driver;

	public HomePage (WebDriver driver)
	{
		this.driver=driver;;
	}
	public static String getURl()
	{
		return driver.getCurrentUrl();
	}
  public static void fetchLinks()
  {
	  System.out.println("The Links in home page are:");
	  List<WebElement> Homelink_list=driver.findElements(By.xpath("//a[@class='media__link']"));
	  for(WebElement w:Homelink_list)
		  System.out.println(w.getText());
	  
	  
  }
  public static void fetchtopics(String s)
  {
	 WebElement topic= driver.findElement(By.xpath("//h2[@class='module__title']//child::a[contains(text(),'News')]"));
			 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView();",topic); 
	  List<WebElement> title_list=driver.findElements(By.xpath("//section[@class='module module--news   module--collapse-images']//div[@class='media__content']//a[@class='media__link']"));
		List<WebElement> desc_list=driver.findElements(By.xpath("//section[@class='module module--news   module--collapse-images']//div[@class='media__content']//p"));
		System.out.println("Links presnt in  "+s+"  are:");
		for(WebElement w:title_list)
			System.out.println(w.getText());
		System.out.println("T?he description are:");
		for(WebElement w:desc_list)
		{
		System.out.println(	w.getText());
		}
  }
  public static  void corresponding_link()
  {
	  List<WebElement> list=driver.findElements(By.xpath("//section[@class='module module--news   module--collapse-images']//div[@class='media  block-link']"));
	  for(WebElement w:list)
	  {
		  System.out.println("====================================");
			System.out.println(w.getAttribute("data-bbc-title"));
			System.out.println("--------------------------------");
		System.out.println(	w.findElement(By.tagName("p")).getText());
			System.out.println("====================================");
	  
  }
}
}
