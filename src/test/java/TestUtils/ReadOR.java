package TestUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadOR {
  public static FileInputStream fis;
  public static Properties pro;
  public static String getLocator(String s) {
	  
	  try
	  {
		  fis=new FileInputStream("C:\\Sprint2BBC\\src\\test\\resources\\PropertyFiles\\Config.properties");
		  pro=new Properties();
		  pro.load(fis);
		  return pro.getProperty(s);
	  }
	  catch(Exception e)
		{
		e.printStackTrace();	
		}
	 return null;
  }
}
