package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateLeadPage extends SeleniumUtility {
	
	@FindBy(name = "name")
	private WebElement leadNameTxt;
	
	@FindBy(name = "company")
	private WebElement companyNameTxt;
	
	@FindBy(name = "leadSource")
	private WebElement leadSourceTxt;
	
	@FindBy(name = "industry")
	private WebElement industryTxt;
	
	@FindBy(name = "phone")
	private WebElement phoneTxt;
	
	@FindBy(name = "leadStatus")
	private WebElement leadStatusTxt;
	
	@FindBy(name = "rating")
	private WebElement ratingTxt;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//button[.='Create Lead']")
	private WebElement createLeadBtn;

	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadNameTxt()
	{
		return leadNameTxt;
	}

	public WebElement getCompanyNameTxt()
	{
		return companyNameTxt;
	}

	public WebElement getLeadSourceTxt()
	{
		return leadSourceTxt;
	}

	public WebElement getIndustryTxt()
	{
		return industryTxt;
	}

	public WebElement getPhoneTxt()
	{
		return phoneTxt;
	}

	public WebElement getLeadStatusTxt()
	{
		return leadStatusTxt;
	}

	public WebElement getRatingTxt()
	{
		return ratingTxt;
	}
	
	public WebElement getSelectCampaign()
	{
		return selectCampaignBtn;
	}
	
	public WebElement getSelectCampaignBtn()
	{
		return selectCampaignBtn;
	}

	public WebElement getSelDropDown()
	{
		return selDropDown;
	}

	public WebElement getSearchTxt()
	{
		return searchTxt;
	}
	
	public WebElement getCreateLeadBtn()
	{
		return createLeadBtn;
	}
	
	//Business library for create lead
	
	/**
	 * This method will perform create lead operation
	 * @param driver
	 * @param lname
	 * @param lcom
	 * @param lsource
	 * @param lindustry
	 * @param lphone
	 * @param lstatus
	 * @param lrating
	 * @param pWinTitle
	 * @param cWinTitle
	 * @param cname
	 * @throws InterruptedException 
	 */
	
	public void createLead(WebDriver driver, String lname,String lcom,String lsource,String lindustry,String lphone,String lstatus,String lrating,String cname) throws InterruptedException
	{
		leadNameTxt.sendKeys(lname);
		companyNameTxt.sendKeys(lcom);
		leadSourceTxt.sendKeys(lsource);
		industryTxt.sendKeys(lindustry);
		phoneTxt.sendKeys(lphone);
		leadStatusTxt.sendKeys(lstatus);
		ratingTxt.sendKeys(lrating);
		
		selectCampaignBtn.click();
		
		switchToWindow(driver, "Campaign");
		Thread.sleep(3000);
		
		handleDropdown("Campaign Name", selDropDown);
		searchTxt.sendKeys(cname);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+cname+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(3000);
		
		createLeadBtn.click();
		Thread.sleep(8000);
	}

}
