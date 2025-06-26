package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {
	
	@FindBy(xpath = "//span[.='Create Order']")
	private WebElement createSalesOrderBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> SalesOrderSubjectTxt;
	
	public SalesOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateSalesOrderBtn()
	{
		return createSalesOrderBtn;
	}

	public List<WebElement> getSalesOrderSubjectTxt()
	{
		return SalesOrderSubjectTxt;
	}
	
	//Business Library
	
	/**
	 * This method will click on create sales order button
	 */
	
	public void clickOnCreateSalesOrderBtn()
	{
		createSalesOrderBtn.click();
	}
	
	/**
	 * This method will capture all the Sales order subject and compare with required Sales order subject
	 * @param RequiredSalesOrderSubject
	 * @throws InterruptedException
	 */
	
	public void captureSalesOrderSubjectAndCompare(String RequiredSalesOrderSubject) throws InterruptedException
	{
		for (WebElement element : SalesOrderSubjectTxt) {
			 
			String SalesOrderSubject = element.getText();
			if(SalesOrderSubject.equals(RequiredSalesOrderSubject))
			{
				System.out.println(SalesOrderSubject+" Sales Order Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}

}
