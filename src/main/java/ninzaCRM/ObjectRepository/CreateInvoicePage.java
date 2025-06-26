package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateInvoicePage extends SeleniumUtility{
	
	@FindBy(name = "subject")
	private WebElement invoiceSubjectTxt;

	@FindBy(name = "validTill")
	private WebElement invoiceValidTillTxt;
	
	@FindBy(xpath = "(//textarea)[1]")
	private WebElement billAddressTxt;
	
	@FindBy(xpath = "(//input[@name='poBox'])[1]")
	private WebElement billPOTxt;
	
	@FindBy(xpath = "(//input[@name='city'])[1]")
	private WebElement billCityTxt;
	
	@FindBy(xpath = "(//input[@name='state'])[1]")
	private WebElement billStateTxt;
	
	@FindBy(xpath = "(//input[@name='postalCode'])[1]")
	private WebElement billPostalCodeTxt;
	
	@FindBy(xpath = "(//input[@name='country'])[1]")
	private WebElement billCountryTxt;
	
	@FindBy(xpath = "(//textarea)[2]")
	private WebElement shipAddressTxt;
	
	@FindBy(xpath = "(//input[@name='poBox'])[2]")
	private WebElement shipPOTxt;
	
	@FindBy(xpath = "(//input[@name='city'])[2]")
	private WebElement shipCityTxt;
	
	@FindBy(xpath = "(//input[@name='state'])[2]")
	private WebElement shipStateTxt;
	
	@FindBy(xpath = "(//input[@name='postalCode'])[2]")
	private WebElement shipPostalCodeTxt;
	
	@FindBy(xpath = "(//input[@name='country'])[2]")
	private WebElement shipCountryTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[1]")
	private WebElement selectContactBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selContactDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchContactTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[2]")
	private WebElement selectSalesOrderBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selSalesOrderDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchSalesOrderTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[3]")
	private WebElement selectProductBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selProductDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchProductTxt;
	
	@FindBy(xpath = "//button[.='Create Invoice']")
	private WebElement createInvoiceBtn;
	
	public CreateInvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getInvoiceSubjectTxt() 
	{
		return invoiceSubjectTxt;
	}

	public WebElement getInvoiceValidTillTxt() 
	{
		return invoiceValidTillTxt;
	}

	public WebElement getBillAddressTxt() 
	{
		return billAddressTxt;
	}

	public WebElement getBillPOTxt() 
	{
		return billPOTxt;
	}

	public WebElement getBillCityTxt() 
	{
		return billCityTxt;
	}

	public WebElement getBillStateTxt() 
	{
		return billStateTxt;
	}

	public WebElement getBillPostalCodeTxt() 
	{
		return billPostalCodeTxt;
	}

	public WebElement getBillCountryTxt() 
	{
		return billCountryTxt;
	}

	public WebElement getShipAddressTxt() 
	{
		return shipAddressTxt;
	}

	public WebElement getShipPOTxt() 
	{
		return shipPOTxt;
	}

	public WebElement getShipCityTxt() 
	{
		return shipCityTxt;
	}

	public WebElement getShipStateTxt() 
	{
		return shipStateTxt;
	}

	public WebElement getShipPostalCodeTxt() 
	{
		return shipPostalCodeTxt;
	}

	public WebElement getShipCountryTxt() 
	{
		return shipCountryTxt;
	}

	public WebElement getSelectContactBtn() 
	{
		return selectContactBtn;
	}

	public WebElement getSelContactDropDown() 
	{
		return selContactDropDown;
	}

	public WebElement getSearchContactTxt() 
	{
		return searchContactTxt;
	}

	public WebElement getSelectSalesOrderBtn() 
	{
		return selectSalesOrderBtn;
	}

	public WebElement getSelSalesOrderDropDown() 
	{
		return selSalesOrderDropDown;
	}

	public WebElement getSearchSalesOrderTxt() 
	{
		return searchSalesOrderTxt;
	}
	
	public WebElement getSelectProductBtn() 
	{
		return selectProductBtn;
	}

	public WebElement getSelProductDropDown() 
	{
		return selProductDropDown;
	}

	public WebElement getSearchProductTxt() 
	{
		return searchProductTxt;
	}

	public WebElement getCreateInvoiceBtn() 
	{
		return createInvoiceBtn;
	}
	
	//Business library for create invoice
	
	public void createInvoice(WebDriver driver,String iSubject,String iVTill,String bAdd,String bPO,String bCity,String bState,String bpCode,String bCountry,
			String sAdd,String sPO,String sCity,String sState,String spCode,String sCountry,String contact,String salesOrder,String product) throws InterruptedException
	{
		invoiceSubjectTxt.sendKeys(iSubject);
		invoiceValidTillTxt.sendKeys(iVTill);
		selectContactBtn.click();
		
		switchToWindow(driver, "Contact");
		Thread.sleep(3000);
		
		handleDropdown("Contact Name", selContactDropDown);
		searchContactTxt.sendKeys(contact);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+contact+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(3000);
		
		selectSalesOrderBtn.click();
		
		switchToWindow(driver, "Sales-Order");
		Thread.sleep(3000);
		
		handleDropdown("Subject", selSalesOrderDropDown);
		searchSalesOrderTxt.sendKeys(salesOrder);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+salesOrder+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(3000);
		
		billAddressTxt.sendKeys(bAdd);
		billPOTxt.sendKeys(bPO);
		billCityTxt.sendKeys(bCity);
		billStateTxt.sendKeys(bState);
		billPostalCodeTxt.sendKeys(bpCode);
		billCountryTxt.sendKeys(bCountry);
		shipAddressTxt.sendKeys(sAdd);
		shipPOTxt.sendKeys(sPO);
		shipCityTxt.sendKeys(sCity);
		shipStateTxt.sendKeys(sState);
		shipPostalCodeTxt.sendKeys(spCode);
		shipCountryTxt.sendKeys(sCountry);
		
		selectProductBtn.click();
		
		switchToWindow(driver, "Product");
		Thread.sleep(3000);
		
		handleDropdown("Product Name", selProductDropDown);
		searchProductTxt.sendKeys(product);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+product+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(3000);
		
		createInvoiceBtn.click();
		Thread.sleep(8000);
	}

}
