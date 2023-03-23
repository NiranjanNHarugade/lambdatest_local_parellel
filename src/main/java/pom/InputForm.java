package pom;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InputForm {
	
	
	
	@FindBy(xpath="//button[text()='Submit']")private WebElement submit;
	@FindBy(xpath="//input[@id='name']")private WebElement name;
	@FindBy(id="inputEmail4")private WebElement email;
	@FindBy(id="inputPassword4")private WebElement pass;
	@FindBy(id="company")private WebElement company;
	@FindBy(id="websitename")private WebElement website;
	@FindBy(id="inputCity")private WebElement city;
	@FindBy(id="inputAddress1")private WebElement adress;
	@FindBy(id="inputAddress2")private WebElement adress2;
	@FindBy(id="inputState")private WebElement state;
	@FindBy(id="inputZip")private WebElement zip;
	@FindBy(xpath="//select[@name='country']")private WebElement countryDropDown;
	@FindBy(xpath="//p[@class='success-msg hidden']")private WebElement thanksMSG;
	@FindBy(xpath="//span[@id='exit_popup_close']")private WebElement close;

	
	public InputForm(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String Get_ErrorMessage(WebDriver driver,JavascriptExecutor js) throws InterruptedException 
	{	
		js.executeScript("window.scroll(0,400)", "");
		Thread.sleep(500);
		submit.click();
		String ErrorMsg=name.getAttribute("validationMessage");
		return ErrorMsg;
	}
	
	
	
	public void FillForm(WebDriver driver,JavascriptExecutor js) throws InterruptedException {
		name.sendKeys("Niranjan H");
		email.sendKeys("Nnharugade@gmail.com");
		pass.sendKeys("pass@123");
		company.sendKeys("All india pvt ltd");
		website.sendKeys("alldiacom");
		city.sendKeys("California");
		adress.sendKeys("4501 S Alameda St, Los Angeles");
		adress2.sendKeys("4501 S Alameda St, Los Angeles");
		state.sendKeys("LA");
		zip.sendKeys("90058");
		Select s= new Select(countryDropDown);
		s.selectByVisibleText("United States");
		Thread.sleep(500);
		js.executeScript("arguments[0].click()", close);
		
		}
		
		
	
	

	public String getmessage() throws InterruptedException 
	{
		submit.click();
		String msg=thanksMSG.getText();
		return msg;	
	}
	
}
