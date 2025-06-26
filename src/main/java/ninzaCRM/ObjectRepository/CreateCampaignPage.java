package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	@FindBy(name = "campaignName")
	private WebElement campaignNameTxt;
	
	@FindBy(name = "targetSize")
	private WebElement targetSizeTxt;
	
	@FindBy(xpath = "//button[.='Create Campaign']")
	private WebElement createCampaignBtn;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCampaignNameTxt()
	{
		return campaignNameTxt;
	}

	public WebElement getTargetSizeTxt()
	{
		return targetSizeTxt;
	}

	public WebElement getCreateCampaignBtn_2()
	{
		return createCampaignBtn;
	}
	

	//Business Library for create campaign
	
	/**
	 * This method will perform create campaign operation
	 * @param cname
	 * @param tsize
	 * @throws InterruptedException 
	 */
	
	public void createCampaign(String cname,String tsize) throws InterruptedException
	{
		campaignNameTxt.sendKeys(cname);
		targetSizeTxt.sendKeys(tsize);
		createCampaignBtn.click();
		Thread.sleep(8000);
	}


}
