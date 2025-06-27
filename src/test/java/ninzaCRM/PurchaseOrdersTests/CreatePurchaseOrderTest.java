package ninzaCRM.PurchaseOrdersTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.AddProductPage;
import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;
import ninzaCRM.ObjectRepository.CreatePurchaseOrderPage;
import ninzaCRM.ObjectRepository.ProductsPage;
import ninzaCRM.ObjectRepository.PurchaseOrderPage;

public class CreatePurchaseOrderTest extends BaseClass{
	
	@Test
	public void createPurchaseOrder() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read test data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("System", 1, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("System", 1, 26);
		String CONTACTNAME = eUtil.readDataFromExcel("System", 1, 3);
		String MOBILE = eUtil.readDataFromExcel("System", 1, 4);
		String ORGANIZATIONNAME = eUtil.readDataFromExcel("System", 1, 5);
		String TITLE = eUtil.readDataFromExcel("System", 1, 6);
		String PRODUCTNAME = eUtil.readDataFromExcel("System", 1, 7)+jUtil.getRandomNumber();
		String CATEGORY = eUtil.readDataFromExcel("System", 1, 8);
		String QUANTITY = eUtil.readDataFromExcel("System", 1, 9);
		String PRICE = eUtil.readDataFromExcel("System", 1, 10);
		String VENDOR = eUtil.readDataFromExcel("System", 1, 11);
		String SUBJECT = eUtil.readDataFromExcel("System", 1, 12)+jUtil.getRandomNumber();
		String DATE = eUtil.readDataFromExcel("System", 1, 13);
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
		
		//Click on Purchase Order
		cp.clickOnPurchaseOrderLnk();
		
		//Click on create purchase order
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.clickOnCreatePurchaseOrder();
		
		//Create Purchase order with mandatory fields
		CreatePurchaseOrderPage cpop = new CreatePurchaseOrderPage(driver);
		cpop.createPurchaseOrder(driver, SUBJECT, DATE, BILLINGADDRESS, BILLINGPO, BILLINGCITY, BILLINGSTATE, BILLINGPOSTALCODE, BILLINGCOUNTRY, SHIPPINGADDRESS, SHIPPINGPO, SHIPPINGCITY, SHIPPINGSTATE, SHIPPINGPOSTALCODE, SHIPPINGCOUNTRY, CONTACTNAME, PRODUCTNAME);
		
		//Validate for the purchase order
		pop.capturePurchaseOrderSubjectAndCompare(SUBJECT);
	}

}
