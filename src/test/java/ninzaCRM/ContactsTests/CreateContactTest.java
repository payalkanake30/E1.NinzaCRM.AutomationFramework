package ninzaCRM.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;

public class CreateContactTest extends BaseClass{
	
	@Test
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read test data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 4, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 4, 3);
		String ORGANIZATIONNAME = eUtil.readDataFromExcel("Integration", 4, 6);
		String TITLE = eUtil.readDataFromExcel("Integration", 4, 7);
		String CONTACTNAME = eUtil.readDataFromExcel("Integration", 4, 4);
		String MOBILE = eUtil.readDataFromExcel("Integration", 4, 5);
		
		//Click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
		Thread.sleep(3000);
		cp.clickOnCreateCampaignBtn();
		
		//Create campaign with mandatory fields
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		//Click on Contacts link
		cp.clickOnContactsLnk();
		
		//Click on create contact button
		ContactsPage cop = new ContactsPage(driver);
		cop.clickOnCreateContactBtn();
		
		//Create contact with mandatory fields
		CreateContactPage ccop = new CreateContactPage(driver);
		ccop.createContact(driver, ORGANIZATIONNAME, TITLE, CONTACTNAME, MOBILE, CAMPAIGNNAME);
		
		//Validate for the contact
		cop.captureContactNamesAndCompare(CONTACTNAME);
		
	}

}
