package lambdatest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.SetUp_config;
import pom.DragAndDrop;
import pom.FormPage;
import pom.HomePage;
import pom.InputForm;

public class Assignment_1 extends SetUp_config {

	HomePage HM;
	FormPage FP;
	DragAndDrop DP;
	InputForm IF;
	 
	 @BeforeClass @Parameters({"browser"})
	public void Openbrowser(String browser) {
	
		launch_browser(browser);
		HM = new HomePage(driver);
		FP = new FormPage(driver);
		DP = new DragAndDrop(driver);
		IF = new InputForm(driver);	
	}

	@Test(priority = 1)
	public void Scenario_1() throws InterruptedException {
		HM.ClickOn_DemoLink();
		
		String Exp_URL = "simple-form-demo";
		String Act_URL = driver.getCurrentUrl();

		Assert.assertTrue(Act_URL.contains(Exp_URL), "URL not contains " + Act_URL);
		Reporter.log("Url Contains = " + Exp_URL, true);
		
		String Exp_Text ="Welcome to LambdaTest";
		String Act_Text =FP.GetText(driver,js);
		
		
		Assert.assertEquals(Act_Text, Exp_Text,"Showing Incurrect text message "+Act_Text);
		Reporter.log("TextBox Showing Currect text message = "+Exp_Text, true);
	}

	@Test(priority = 2)
	public void Scenario_2() throws InterruptedException {
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
		Thread.sleep(200);
		HM.ClickON_Draganddrop();
		
		String Exp_Value = "95";
		String Act_Value = DP.AdjustSlider(driver,js, act);
		
		Assert.assertEquals(Act_Value, Exp_Value, "Range Not showing currect value");
		Reporter.log("Slider possition set to = " + Exp_Value, true);
	}

	@Test(priority = 3)
	public void Scenario_3() throws InterruptedException {
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
		Thread.sleep(200);
		HM.ClickOn_Input_Form();
		
		String Exp_ErrorMsg="Please fill out this field.";
		String Act_ErrorMsg= IF.Get_ErrorMessage(driver,js);
		
		Assert.assertEquals(Exp_ErrorMsg, Act_ErrorMsg, "Error message is not correct = "+Act_ErrorMsg);
		Reporter.log("Showing correct warning message = "+Exp_ErrorMsg, true);
		
		IF.FillForm(driver,js);
		
		String Act_SuccessMsg=IF.getmessage();
		String Exp_SuccessMsg="Thanks for contacting us, we will get back to you shortly.";
		
		Assert.assertEquals(Act_SuccessMsg, Exp_SuccessMsg,"Incorrect success message = "+Act_SuccessMsg);
		Reporter.log("Showing correct success message = " + Exp_SuccessMsg, true);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	

}
