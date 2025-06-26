package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	@FindBy(xpath = "//span[.='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaignBtn_1() {
		return createCampaignBtn;
	}

	
	//Business Library 
	
	/**
	 * This method will click on create campaign button
	 * 
	 */
	
	public void ClickOnCreateCampaignBtn()
	{
		createCampaignBtn.click();
		
	}
	/**
	 * This method will click on create campaign button
	 * 
	 */

	public void clickOnCreateCampaignBtn() {
		createCampaignBtn.click();

	}

	/**
	 * This method will click on leads link
	 * 
	 */
	public void clickOnLeadsLnk() {
		leadsLnk.click();
	}

}
