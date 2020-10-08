package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PageBase {

	public JavascriptExecutor jse ; 
	public Select select ; 
	public Actions action ; 

	// create constructor 
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement button) 
	{
		button.click();
	}

	protected static void selectFromDropDownBootstrap(WebElement list, String value)
	{
		List<WebElement> options = list.findElements(By.tagName("span"));

		for(WebElement element:options){

			String innerhtml=element.getAttribute("innerHTML");

			if(innerhtml.contentEquals(value)){
				element.click();
				break;
			}
		}

	}

	protected static void selectFromDropDown(WebElement list, String value)
	{
		Select select = new Select(list);
		select.selectByVisibleText(value);

	}
	
	protected static void setTextElementText(WebElement textElement , String value) 
	{
		textElement.isDisplayed();
		textElement.sendKeys(value);
	}
	
	public void scrollToBottom()
	
	{
		jse.executeScript("scrollBy(0,1500)");

	}
	
	public void clearText(WebElement element) 
	{
		element.clear();
	}

	protected static void verifyElemetnDisplayed(WebElement element) {
		element.isDisplayed();
		
	}

	protected static void verifyElementText(WebElement textElement , String value)
	{
		textElement.getText().contains(value);

	}
	protected static void hitEnter(WebElement Element)
	{
		Element.sendKeys(Keys.ENTER);
	}

	protected static void getAttributeAndAssert(WebElement Element, String elemAttr)
	{
		String attr= Element.getAttribute("href");
		assertEquals(attr,elemAttr);
	}


}
