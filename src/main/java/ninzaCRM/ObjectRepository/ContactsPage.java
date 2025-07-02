package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath = "//span[.='Create Contact']")
	private WebElement createContactBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> ContactsNameTxt;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactBtn()
	{
		return createContactBtn;
	}

	public List<WebElement> getContactsNameTxt()
	{
		return ContactsNameTxt;
	}
	
	//Business Library
	
	/**
	 * This method will click on create contact button
	 */
	
	public void clickOnCreateContactBtn()
	{
		createContactBtn.click();
	}
	
	/**
	 * This method will capture all the contact names and compare with required contact Name
	 * @param RequiredContactName
	 * @throws InterruptedException 
	 */
	
	public void captureContactNamesAndCompare(String RequiredContactName) throws InterruptedException
	{
		for(WebElement element : ContactsNameTxt)
		{
			String ContactName = element.getText();
			if(ContactName.equals(RequiredContactName))
			{
				System.out.println(ContactName+" Contact Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}
}
