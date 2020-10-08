package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GitHubHomePage extends PageBase
{
	public GitHubHomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	//Selectors

	@FindBy(xpath="//header/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/label[1]/input[1]")
	WebElement SearchBar ;

	@FindBy(xpath="//body/div[4]/main[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/div[2]/div[1]/a[1]")
	WebElement firstOption ;

	@FindBy(css="img[alt=\"CPython build status on Travis CI\"]")
	WebElement buildImg ;

	@FindBy(css="img[alt=\"CPython build status on GitHub Actions\"]")
	WebElement testsImg ;

	@FindBy(css="img[alt=\"CPython build status on Azure DevOps\"]")
	WebElement azureImg ;

	@FindBy(css="img[alt=\"CPython code coverage on Codecov\"]")
	WebElement codecovImg ;

	@FindBy(css="img[alt=\"Python Zulip chat\"]")
	WebElement zulibImg ;

	//Home page steps
	public void searchForContent(String searchText,String urlElement)
	{
		setTextElementText(SearchBar,searchText);
		hitEnter(SearchBar);
		getAttributeAndAssert(firstOption,urlElement);
		clickButton(firstOption);
		scrollToBottom();
		verifyElemetnDisplayed(buildImg);
		verifyElemetnDisplayed(testsImg);
		verifyElemetnDisplayed(azureImg);
		verifyElemetnDisplayed(codecovImg);
		verifyElemetnDisplayed(zulibImg);

	}

}
