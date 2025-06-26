package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotesPage {
	
	@FindBy(xpath = "//span[.='Create Quote']")
	private WebElement createQuoteBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> QuoteSubjectTxt;
	
	public QuotesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateQuoteBtn() 
	{
		return createQuoteBtn;
	}

	public List<WebElement> getQuoteSubjectTxt() 
	{
		return QuoteSubjectTxt;
	}
	
	//Business Library

	/**
	 * This method will click on create quote button
	 */
	
	public void clickOnCreateQuote()
	{
		createQuoteBtn.click();
	}
	
	/**
	 * This method will capture all the quote names and compare with required quote Name
	 * @param RequiredQuotesSubject
	 * @throws InterruptedException
	 */
	
	public void captureQuotesSubjectAndCompare(String RequiredQuotesSubject) throws InterruptedException
	{
		for (WebElement element : QuoteSubjectTxt) {
			 
			String QuotesSubject = element.getText();
			if(QuotesSubject.equals(RequiredQuotesSubject))
			{
				System.out.println(QuotesSubject+" Quote Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}

}
