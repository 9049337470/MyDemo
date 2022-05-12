package com.qa.Testbase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase_Class1 
{
	
public static WebDriver driver;
@Test
	public void start()
	{
		String abc="chrome";
		if(abc.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(abc.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(abc.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Please Enter valid URl of browsser");
		}
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//driver.quit();
		
		
		WebElement e1 = driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[1]"));
		Actions a=new Actions(driver);
		a.moveToElement(e1).build().perform();
		
		WebElement e2 = driver.findElement(By.xpath("(//span[text()='हिन्दी'])[1]"));
		a.click(e2).build().perform();
		driver.quit();
		}

	

}
