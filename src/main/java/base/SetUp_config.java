package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class SetUp_config {

	
	
	public  WebDriver driver=null;
	public JavascriptExecutor js;
	public Actions act;
	

	public void launch_browser(String Name) 
	{
		if(Name.equalsIgnoreCase("chrome"))
		{ 	ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			
			driver=new ChromeDriver(opt);
		}
		else if(Name.equalsIgnoreCase("firefox")) {driver=new FirefoxDriver();}
		else if(Name.equalsIgnoreCase("edge")) {driver=new EdgeDriver();}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().deleteAllCookies();
	driver.get("https://www.lambdatest.com/selenium-playground");
	
	js=((JavascriptExecutor)driver);
	act = new Actions(driver);
	}
	
	
}
