package webpage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class project {
	ChromeDriver driver;
  @BeforeMethod
  public void launch() {
	    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://192.168.56.103:3001");
  }
  
  @Test
  public void verify() {
	  driver.findElement(By.xpath("//a[@href='/content/about-us.php']")).click();
	  String x = driver.getCurrentUrl();
	  System.out.println(x);
	  Assert.assertEquals(x,"http://192.168.56.103:3001/content/about-us.php");
	  driver.navigate().back();
	  driver.findElement(By.xpath("//a[@href='/content/products.php']")).click();
	  String y = driver.getCurrentUrl();
	  System.out.println(y);
	  Assert.assertEquals(y,"http://192.168.56.103:3001/content/products.php");
	  driver.navigate().back();
	  driver.findElement(By.xpath("//a[@href='/content/contact.php']")).click();
	  String z = driver.getCurrentUrl();
	  System.out.println(z);
	  Assert.assertEquals(z,"http://192.168.56.103:3001/content/contact.php");
	  driver.navigate().back();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
