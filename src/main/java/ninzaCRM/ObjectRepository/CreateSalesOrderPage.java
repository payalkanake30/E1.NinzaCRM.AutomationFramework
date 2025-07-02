package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateSalesOrderPage extends SeleniumUtility{
	
	@FindBy(name = "subject")
	private WebElement salesOrderSubjectTxt;

	@FindBy(name = "validTill")
	private WebElement validTillTxt;
	
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
	private WebElement selectOpportunityBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selOpportunityDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchOpportunityTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[2]")
	private WebElement selectQuoteBtn;
	
	@FindBy(id = "search-field")
	private WebElement selQuoteDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchQuoteTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[3]")
	private WebElement selectContactBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selContactDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchContactTxt;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[4]")
	private WebElement selectProductBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selProductDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchProductTxt;
	
	@FindBy(xpath = "//button[.='Create Sales Order']")
	private WebElement createSalesOrderBtn;
	
	public CreateSalesOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSalesOrderSubjectTxt()
	{
		return salesOrderSubjectTxt;
	}

	public WebElement getValidTillTxt()
	{
		return validTillTxt;
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

	public WebElement getSelectOpportunityBtn()
	{
		return selectOpportunityBtn;
	}

	public WebElement getSelOpportunityDropDown()
	{
		return selOpportunityDropDown;
	}

	public WebElement getSearchOpportunityTxt()
	{
		return searchOpportunityTxt;
	}

	public WebElement getSelectQuoteBtn()
	{
		return selectQuoteBtn;
	}

	public WebElement getSelQuoteDropDown()
	{
		return selQuoteDropDown;
	}

	public WebElement getSearchQuoteTxt()
	{
		return searchQuoteTxt;
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

	public WebElement getCreateSalesOrderBtn()
	{
		return createSalesOrderBtn;
	}
	
	//Business library for create sales order
	
	/**
	 * This method will perform create sales order operation
	 * @param driver
	 * @param soSubject
	 * @param vTill
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
	 * @param opportunity
	 * @param quote
	 * @param contact
	 * @param product
	 * @throws InterruptedException
	 */
	
	public void createSalesOrder(WebDriver driver,String soSubject,String vTill,String bAdd,String bPO,String bCity,String bState,String bpCode,String bCountry,String sAdd,
			String sPO,String sCity,String sState,String spCode,String sCountry,String opportunity,String quote,String contact,String product) throws InterruptedException
	{
		salesOrderSubjectTxt.sendKeys(soSubject);
		validTillTxt.sendKeys(vTill);
		selectOpportunityBtn.click();
		
		switchToWindow(driver, "Opportunity");
		Thread.sleep(3000);
		
		handleDropdown("Opportunity Name", selOpportunityDropDown);
		searchOpportunityTxt.sendKeys(opportunity);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+opportunity+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(3000);
		
		selectQuoteBtn.click();
		
		switchToWindow(driver, "Quote");
		Thread.sleep(3000);
		
		handleDropdown("Subject", selQuoteDropDown);
		searchQuoteTxt.sendKeys(quote);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+quote+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(3000);
		
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
		
		createSalesOrderBtn.click();
		Thread.sleep(8000);
	}

}
