package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CampaignsPage extends SeleniumUtility{
	
	@FindBy(xpath = "//span[.='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> CampaignNameTxt;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Quotes")
	private WebElement quotesLnk;
	
	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseOrderLnk;
	
	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderLnk;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoiceLnk;
	
	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logoutLnk;
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateCampaignBtn() 
	{
		return createCampaignBtn;
	}

	public WebElement getContactsLnk() 
	{
		return contactsLnk;
	}

	public WebElement getLeadsLnk() 
	{
		return leadsLnk;
	}

	public WebElement getOpportunitiesLnk() 
	{
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() 
	{
		return productsLnk;
	}

	public WebElement getQuotesLnk() 
	{
		return quotesLnk;
	}

	public WebElement getPurchaseOrderLnk() 
	{
		return purchaseOrderLnk;
	}

	public WebElement getSalesOrderLnk() 
	{
		return salesOrderLnk;
	}

	public WebElement getInvoiceLnk() 
	{
		return invoiceLnk;
	}

	public WebElement getUserIcon() 
	{
		return userIcon;
	}

	public WebElement getLogoutLnk() 
	{
		return logoutLnk;
	}

	
	//Business Library for campaign page
	
	/**
	 * This method will click on create campaign button
	 */
	
	public void clickOnCreateCampaignBtn()
	{
		createCampaignBtn.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}
	
	/**
	 * This method will click on leads link
	 */
	
	public void clickOnLeadsLnk()
	{
		leadsLnk.click();
	}
	
	/**
	 * This method will click on opportunities link
	 */
	
	public void clickOnOpportunitiesLnk()
	{
		opportunitiesLnk.click();
	}
	
	/**
	 * This method will click on product link
	 */
	
	public void clickOnProductsLnk()
	{
		productsLnk.click();
	}
	
	/**
	 * This method will click on quotes link
	 */
	
	public void clickOnQuotesLnk()
	{
		quotesLnk.click();
	}
	
	/**
	 * This method will click on purchase order link
	 */
	
	public void clickOnPurchaseOrderLnk()
	{
		purchaseOrderLnk.click();
	}
	
	/**
	 * This method will click on sales order link
	 */
	
	public void clickOnSalesOrderLnk()
	{
		salesOrderLnk.click();
	}
	
	/**
	 * This method will click on invoice link
	 */
	
	public void clickOnInvoiceLnk()
	{
		invoiceLnk.click();
	}
	
	/**
	 * This method will perform logout operation
	 * @param driver
	 * @throws InterruptedException
	 */
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, userIcon);
		Thread.sleep(4000);
		logoutLnk.click();
	}
	
	public void captureCampaignNameAndCompare(String RequiredCampaignName) throws InterruptedException
	{
		for (WebElement element : CampaignNameTxt) {
			 
			String CampaignName = element.getText();
			if(CampaignName.equals(RequiredCampaignName))
			{
				System.out.println(CampaignName+" Campaign Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}

}
