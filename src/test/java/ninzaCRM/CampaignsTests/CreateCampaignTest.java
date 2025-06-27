package ninzaCRM.CampaignsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;

public class CreateCampaignTest extends BaseClass{
	
	@Test
	public void createCampaign() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 7, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 7, 15);
		
		//Click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		//Create campaign with mandatory fields
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		//Validate for campaign
		cp.captureCampaignNameAndCompare(CAMPAIGNNAME);
	}

}
