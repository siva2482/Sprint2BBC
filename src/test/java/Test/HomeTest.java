package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;

public class HomeTest extends TestBase {

	
	//public  WebDriver driver;
	HomePage obj=new HomePage(driver);
	
	@Test
	public void run()
	{
		Assert.assertEquals("https://www.bbc.com/",obj.getURl());
		System.out.println(obj.getURl());
		obj.fetchLinks();
		//obj.fetchtopics("News");
		obj.corresponding_link();
	}
}
