package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	@FindBy(xpath="//a[text()='Simple Form Demo']")private WebElement Demolink;
	@FindBy(xpath="//a[text()='Drag & Drop Sliders']")private WebElement dragandDrop;
	@FindBy(xpath="//a[text()='Input Form Submit']")private WebElement inputform;

	
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOn_DemoLink() 
	{
		Demolink.click();
	}
	
	
	public void ClickON_Draganddrop()
	{
		dragandDrop.click();
	}
	
	public void ClickOn_Input_Form() 
	{
		inputform.click();
	}
	
}
