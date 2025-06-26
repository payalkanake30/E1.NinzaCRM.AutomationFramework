package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateOpportunityPage extends SeleniumUtility {
	
	@FindBy(name = "opportunityName")
	private WebElement opportunityNameTxt;
	
	@FindBy(name = "amount")
	private WebElement ammountTxt;
	
	@FindBy(name = "businessType")
	private WebElement businessTypeTxt;
	
	@FindBy(name = "nextStep")
	private WebElement nextStepTxt;
	
	@FindBy(name = "salesStage")
	private WebElement salesStageTxt;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectLeadBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selDropDown;
	
	@FindBy(id = "search-input")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//button[.='Create Opportunity']")
	private WebElement createOpportunityBtn;
	
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityNameTxt()
	{
		return opportunityNameTxt;
	}

	public WebElement getAmmountTxt()
	{
		return ammountTxt;
	}

	public WebElement getBusinessTypeTxt()
	{
		return businessTypeTxt;
	}

	public WebElement getNextStepTxt()
	{
		return nextStepTxt;
	}

	public WebElement getSalesStageTxt()
	{
		return salesStageTxt;
	}

	public WebElement getSelectLeadBtn()
	{
		return selectLeadBtn;
	}

	public WebElement getSelDropDown()
	{
		return selDropDown;
	}

	public WebElement getSearchTxt()
	{
		return searchTxt;
	}
	
	public WebElement getCreateOpportunityBtn() 
	{
		return createOpportunityBtn;
	}

	//Business library for create opportunity

	/**
	 * This method will perform create opportunity operation
	 * @param driver
	 * @param oName
	 * @param OAmmount
	 * @param oBType
	 * @param oNStep
	 * @param oSStage
	 * @param pWinTitle
	 * @param cWinTitle
	 * @param lname
	 * @throws InterruptedException 
	 */
	
	public void createOpportunity(WebDriver driver,String opName,String opAmmount,String oBType,String oNStep,String oSStage,String lname) throws InterruptedException
	{
		opportunityNameTxt.sendKeys(opName);
		ammountTxt.sendKeys(opAmmount);
		businessTypeTxt.sendKeys(oBType);
		nextStepTxt.sendKeys(oNStep);
		salesStageTxt.sendKeys(oSStage);
		
		selectLeadBtn.click();
		
		switchToWindow(driver, "Lead");
		Thread.sleep(3000);
		
		handleDropdown("Lead Name", selDropDown);
		searchTxt.sendKeys(lname);
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("//td[.='"+lname+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(3000);
		
		createOpportunityBtn.click();
		Thread.sleep(8000);
	}

}
