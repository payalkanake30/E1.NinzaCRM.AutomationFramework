package ninzaCRM.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.AddProductPage;
import ninzaCRM.ObjectRepository.CampaignsPage;
import ninzaCRM.ObjectRepository.ProductsPage;

public class CreateProductTest extends BaseClass{
	
	@Test
	public void createProduct() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read test data from excel file
		String PRODUCTNAME = eUtil.readDataFromExcel("Integration", 19, 2)+jUtil.getRandomNumber();
		String CATEGORY = eUtil.readDataFromExcel("Integration", 19, 3);
		String QUANTITY = eUtil.readDataFromExcel("Integration", 19, 4);
		String PRICE = eUtil.readDataFromExcel("Integration", 19, 5);
		String VENDOR = eUtil.readDataFromExcel("Integration", 19, 6);
		
		//Click on products page
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnProductsLnk();
		
		//Click on add product
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnAddProductBtn();
		
		//Create product with mandatory fields
		AddProductPage ap = new AddProductPage(driver);
		ap.addProduct(driver, PRODUCTNAME, CATEGORY, QUANTITY, PRICE, VENDOR);
		
		//Validate for the Product
		pp.captureProductNamesAndCompare(PRODUCTNAME);
	}

}
