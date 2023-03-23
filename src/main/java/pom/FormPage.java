package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
	
	@FindBy(xpath="//input[@id='user-message']")private WebElement textbox;
	@FindBy(id = "showInput")private WebElement checkbutton;
	@FindBy(id = "message")private WebElement text;
	

	public FormPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String GetText(WebDriver driver,JavascriptExecutor js) throws InterruptedException 
	{	
		js.executeScript("window.scroll(0,500)","");
		String Exp_Text="Welcome to LambdaTest";
		textbox.sendKeys(Exp_Text);
		Thread.sleep(300);
		checkbutton.click();
		String Act_Text = text.getText();
		return Act_Text;	
	}
	
	
}
