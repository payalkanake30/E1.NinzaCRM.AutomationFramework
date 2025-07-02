package ninzaCRM.OpportunitiesTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.CreateOpportunityPage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.OpportunitiesPage;

public class CreateOpportunityTest extends BaseClass{
	
	@Test
	public void createOpportunity() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read test data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 7, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 7, 15);
		String LEADNAME = eUtil.readDataFromExcel("Integration", 7, 3)+jUtil.getRandomNumber();
		String COMPANY = eUtil.readDataFromExcel("Integration", 7, 4);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration", 7, 5);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration", 7, 6);
		String INDUSTRY = eUtil.readDataFromExcel("Integration", 7, 7);
		String RATING = eUtil.readDataFromExcel("Integration", 7, 8);
		String PHONE = eUtil.readDataFromExcel("Integration", 7, 9);
		String OPPORTUNITYNAME = eUtil.readDataFromExcel("Integration", 7, 10)+jUtil.getRandomNumber();
		String OPPORTUNITYAMMOUNT = eUtil.readDataFromExcel("Integration", 7, 11);
		String BUSINESSTYPE = eUtil.readDataFromExcel("Integration", 7, 12);
		String NEXTSTEP = eUtil.readDataFromExcel("Integration", 7, 13);
		String SALESSTAGE = eUtil.readDataFromExcel("Integration", 7, 14);
		
		//Click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCreateCampaignBtn();
		
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
		
		//Click on opportunities link
		cp.clickOnOpportunitiesLnk();
		
		//Click on create opportunity button
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickOnCreateOpportunityBtn();
		
		//Create opportunity with mandatory fields
		CreateOpportunityPage copp = new CreateOpportunityPage(driver);
		copp.createOpportunity(driver, OPPORTUNITYNAME, OPPORTUNITYAMMOUNT, BUSINESSTYPE, NEXTSTEP, SALESSTAGE, LEADNAME);
		
		//Validate for the opportunity
		op.captureOpportunityNameAndCompare(OPPORTUNITYNAME);
	}

}
