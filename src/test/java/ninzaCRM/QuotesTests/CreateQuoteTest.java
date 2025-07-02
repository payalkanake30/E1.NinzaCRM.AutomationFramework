package ninzaCRM.QuotesTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.AddProductPage;
import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.CreateOpportunityPage;
import ninzaCRM.ObjectRepository.CreateQuotePage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.OpportunitiesPage;
import ninzaCRM.ObjectRepository.ProductsPage;
import ninzaCRM.ObjectRepository.QuotesPage;

public class CreateQuoteTest extends BaseClass{
	
	@Test
	public void createQuote() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 7, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 7, 15);
		String CONTACTNAME = eUtil.readDataFromExcel("System", 1, 3);
		String MOBILE = eUtil.readDataFromExcel("System", 1, 4);
		String ORGANIZATIONNAME = eUtil.readDataFromExcel("System", 1, 5);
		String TITLE = eUtil.readDataFromExcel("System", 1, 6);
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
		String PRODUCTNAME = eUtil.readDataFromExcel("System", 1, 7)+jUtil.getRandomNumber();
		String CATEGORY = eUtil.readDataFromExcel("System", 1, 8);
		String QUANTITY = eUtil.readDataFromExcel("System", 1, 9);
		String PRICE = eUtil.readDataFromExcel("System", 1, 10);
		String VENDOR = eUtil.readDataFromExcel("System", 1, 11);
		String QUOTENAME = eUtil.readDataFromExcel("Integration", 13, 2)+jUtil.getRandomNumber();
		String VALIDTILL = eUtil.readDataFromExcel("Integration", 13, 3);
		String QUOTESTAGE = eUtil.readDataFromExcel("Integration", 13, 4);
		String BILLINGADDRESS = eUtil.readDataFromExcel("System", 1, 14);
		String BILLINGPO = eUtil.readDataFromExcel("System", 1, 15);
		String BILLINGCITY = eUtil.readDataFromExcel("System", 1, 16);
		String BILLINGSTATE = eUtil.readDataFromExcel("System", 1, 17);
		String BILLINGPOSTALCODE = eUtil.readDataFromExcel("System", 1, 18);
		String BILLINGCOUNTRY = eUtil.readDataFromExcel("System", 1,19);
		String SHIPPINGADDRESS = eUtil.readDataFromExcel("System", 1, 20);
		String SHIPPINGPO = eUtil.readDataFromExcel("System", 1, 21);
		String SHIPPINGCITY = eUtil.readDataFromExcel("System", 1, 22);
		String SHIPPINGSTATE = eUtil.readDataFromExcel("System", 1, 23);
		String SHIPPINGPOSTALCODE = eUtil.readDataFromExcel("System", 1, 24);
		String SHIPPINGCOUNTRY = eUtil.readDataFromExcel("System", 1, 25);
		
		//Click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
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
		
		//Click on products page
		cp.clickOnProductsLnk();
		
		//Click on add product
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnAddProductBtn();
		
		//Create product with mandatory fields
		AddProductPage ap = new AddProductPage(driver);
		ap.addProduct(driver, PRODUCTNAME, CATEGORY, QUANTITY, PRICE, VENDOR);
		
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
		
		//Click on quotes link
		cp.clickOnQuotesLnk();
		
		//Click on create quote button
		QuotesPage qp = new QuotesPage(driver);
		qp.clickOnCreateQuote();
		
		//Create quote with mandatory fields
		CreateQuotePage cqp = new CreateQuotePage(driver);
		cqp.createQuote(driver, QUOTENAME, VALIDTILL, QUOTESTAGE, BILLINGADDRESS, BILLINGPO, BILLINGCITY, BILLINGSTATE, BILLINGPOSTALCODE, BILLINGCOUNTRY, SHIPPINGADDRESS, SHIPPINGPO, SHIPPINGCITY, SHIPPINGSTATE, SHIPPINGPOSTALCODE, SHIPPINGCOUNTRY, OPPORTUNITYNAME, CONTACTNAME, PRODUCTNAME);
		
		//Validate for the quote
		qp.captureQuotesSubjectAndCompare(QUOTENAME);
	}
	

}
