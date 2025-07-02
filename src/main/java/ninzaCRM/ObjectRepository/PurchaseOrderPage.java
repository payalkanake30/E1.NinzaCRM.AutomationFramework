package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	
	@FindBy(xpath = "//span[.='Create Order']")
	private WebElement createPurchaseOrderBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> PurchaseOrderSubjectTxt;
	
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatePurchaseOrderBtn() 
	{
		return createPurchaseOrderBtn;
	}

	public List<WebElement> getPurchaseOrderSubjectTxt() 
	{
		return PurchaseOrderSubjectTxt;
	}
	
	//Business Library

	/**
	 * This method will click on create order button
	 */
	
	public void clickOnCreatePurchaseOrder()
	{
		createPurchaseOrderBtn.click();
	}
	
	/**
	 * This method will capture all the purchase order subject and compare with required purchase order subject
	 * @param RequiredPurchaseOrderSubject
	 * @throws InterruptedException
	 */
	
	public void capturePurchaseOrderSubjectAndCompare(String RequiredPurchaseOrderSubject) throws InterruptedException
	{
		for (WebElement element : PurchaseOrderSubjectTxt) {
			 
			String PurchaseOrderSubject = element.getText();
			if(PurchaseOrderSubject.equals(RequiredPurchaseOrderSubject))
			{
				System.out.println(PurchaseOrderSubject+" Purchse Order Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}

}
