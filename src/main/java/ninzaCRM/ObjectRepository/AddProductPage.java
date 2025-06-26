package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class AddProductPage extends SeleniumUtility {
	
	@FindBy(name = "productName")
	private WebElement productNameTxt;
	
	@FindBy(name = "productCategory")
	private WebElement selectCategoryDD;
	
	@FindBy(name = "quantity")
	private WebElement quantityTxt;
	
	@FindBy(name = "price")
	private WebElement priceTxt;
	
	@FindBy(name = "vendorId")
	private WebElement selectVendorDD;
	
	@FindBy(xpath = "//button[.='Add']")
	private WebElement addBtn;
	
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameTxt() 
	{
		return productNameTxt;
	}

	public WebElement getSelectCategoryDD() 
	{
		return selectCategoryDD;
	}

	public WebElement getQuantityTxt() 
	{
		return quantityTxt;
	}

	public WebElement getPriceTxt() 
	{
		return priceTxt;
	}

	public WebElement getSelectVendorDD() 
	{
		return selectVendorDD;
	}

	public WebElement getAddBtn() 
	{
		return addBtn;
	}
	
	//Business Library for add product
	
	public void addProduct(WebDriver driver,String pName,String pCategory,String pQuantity,String price,String vendor) throws InterruptedException
	{
		productNameTxt.sendKeys(pName);
		handleDropdown("Electronics", selectCategoryDD);
		Thread.sleep(3000);
		
		quantityTxt.sendKeys(pQuantity);
		priceTxt.sendKeys(price);
		handleDropdown("Vendor_68300 - (Electronics)", selectVendorDD);
		Thread.sleep(3000);
		
		addBtn.click();
		Thread.sleep(8000);
	}

}
