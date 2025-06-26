package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {

	@FindBy(xpath = "//span[.='Create Invoice']")
	private WebElement createInvoiceBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> InvoiceSubjectTxt;
	
	public InvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateInvoiceBtn() 
	{
		return createInvoiceBtn;
	}

	public List<WebElement> getInvoiceSubjectTxt() 
	{
		return InvoiceSubjectTxt;
	}
	
	//Business Library
	
	/**
	 * This method will click on create invoice button
	 */
	
	public void clickOnCreateInvoiceBtn()
	{
		createInvoiceBtn.click();
	}
	
	/**
	 * This method will capture all the Invoice subject and compare with required Invoice subject
	 * @param RequiredInvoiceSubject
	 * @throws InterruptedException
	 */
	
	public void captureInvoiceSubjectAndCompare(String RequiredInvoiceSubject) throws InterruptedException
	{
		for (WebElement element : InvoiceSubjectTxt) {
			 
			String InvoiceSubject = element.getText();
			if(InvoiceSubject.equals(RequiredInvoiceSubject))
			{
				System.out.println(InvoiceSubject+" Invoice Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}
}
