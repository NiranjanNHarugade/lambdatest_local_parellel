package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDrop {
	@FindBy(xpath = "//div[@class='sp__range sp__range-success']")
	WebElement slider;
	@FindBy(xpath = "//output[@id='rangeSuccess']")
	WebElement percentage;

	public DragAndDrop(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String AdjustSlider(WebDriver driver, JavascriptExecutor js, Actions act) throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,400)", "");
		Thread.sleep(2000);
		act.dragAndDropBy(slider, 98, 0).build().perform();
		String SliderValue = percentage.getText();
		return SliderValue;
	}
}
