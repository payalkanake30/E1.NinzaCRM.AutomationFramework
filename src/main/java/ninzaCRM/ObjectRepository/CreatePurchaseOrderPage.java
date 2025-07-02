package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreatePurchaseOrderPage extends SeleniumUtility{
	
	@FindBy(name = "subject")
	private WebElement purchaseOrderSubjectTxt;

	@FindBy(name = "dueDate")
	private WebElement dueDateTxt;
	
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
	private WebElement selectProductBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selProductDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchProductTxt;
	
	@FindBy(xpath = "//button[.='Create Purchase Order']")
	private WebElement createPurchaseOrderBtn;
	
	public CreatePurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPurchaseOrderSubjectTxt()
	{
		return purchaseOrderSubjectTxt;
	}

	public WebElement getDueDateTxt()
	{
		return dueDateTxt;
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

	public WebElement getCreatePurchaseOrderBtn()
	{
		return createPurchaseOrderBtn;
	}
	
	//Business Library for create purchase order
	
	/**
	 * This method will perform create purchase order operation
	 * @param driver
	 * @param poSubject
	 * @param dueDate
	 * @param bAdd
	 * @param bPO
	 * @param bCity
	 * @param bState
	 * @param bpCode
	 * @param bCountry
	 * @param sAdd
	 * @param sPO
	 * @param sCity
	 * @param sState
	 * @param spCode
	 * @param sCountry
	 * @param contact
	 * @param product
	 * @throws InterruptedException
	 */
	
	public void createPurchaseOrder(WebDriver driver,String poSubject,String dueDate,String bAdd,String bPO,String bCity,String bState,String bpCode,
			String bCountry,String sAdd,String sPO,String sCity,String sState,String spCode,String sCountry,String contact,String product) throws InterruptedException
	{
		purchaseOrderSubjectTxt.sendKeys(poSubject);
		dueDateTxt.sendKeys(dueDate);
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
		
		createPurchaseOrderBtn.click();
		Thread.sleep(8000);
	}
}
