package ninzaCRM.LeadsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.LeadsPage;

public class CreateLeadTest extends BaseClass{
	
	@Test
	public void createLead() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read test data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 1, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 1, 3);
		String LEADNAME = eUtil.readDataFromExcel("Integration", 1, 4);
		String COMPANY = eUtil.readDataFromExcel("Integration", 1, 5);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration", 1, 6);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration", 1, 7);
		String INDUSTRY = eUtil.readDataFromExcel("Integration", 1, 8);
		String RATING = eUtil.readDataFromExcel("Integration", 1, 9);
		String PHONE = eUtil.readDataFromExcel("Integration", 1, 10);
		
		//Click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCreateCampaignBtn(driver);
		
		//Create campaign with mandatory fields
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		//Click on Leads link
		cp.clickOnLeadsLnk();
		
		//Click on create lead button
		LeadsPage lp = new LeadsPage(driver);
		lp.clickOnCreateLeadBtn();
		
		//Create lead with mandatory fields
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.createLead(driver, LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS, RATING, CAMPAIGNNAME);
		
		//Validate for the lead
		lp.captureLeadNamesAndCompare(LEADNAME);
	}

}
