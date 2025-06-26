package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	@FindBy(name = "campaignName")
	private WebElement campaignNameText;
	@FindBy(name = "targetSize")
	private WebElement targetSizeTxt;
	@FindBy(xpath = "//button[.='Create Campaign']")
	private WebElement createCampaignBtn;
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getTargetSizeTxt() {
		return targetSizeTxt;
	}
	public WebElement getTargetCreateCampaignBtn() {
		return createCampaignBtn;
	}
	public void createCampaign(String CampaignName,String TargetSize) {
		campaignNameText.sendKeys(CampaignName);
		targetSizeTxt.sendKeys(TargetSize);
		createCampaignBtn.click();
	}
	
	
}
