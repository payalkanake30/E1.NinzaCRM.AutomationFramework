package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class LeadsPage {
	@FindBy(xpath= "//span[.='Create Lead']")
	private WebElement createLeadBtn;
	
	@FindBy(xpath="//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> LeadNamesTxt;
	
	public WebDriver driver;
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
		
	}
	public WebElement getCreateLeadBtn() {
		 return createLeadBtn;
	}
	SeleniumUtility sUtility=  new SeleniumUtility();
	/**
	 * This method will click on create lead button
	 */
	public void clickOnCreateLeadBtn()
	{
		sUtility.waitForElementToBeVisible(driver, createLeadBtn);
		
		createLeadBtn.click();
	}
	
	public List<WebElement>getLeadNamesTxt(){
		return LeadNamesTxt;
	}
	public void clickOnCreateBtn() {
		createLeadBtn.click();
	}
	public void captureLeadNamesAndCompare(String RequiredLeadName)
	{
		for (WebElement element : LeadNamesTxt) {
			 
			String LeadName = element.getText();
			if(LeadName.equals(RequiredLeadName))
			{
				System.out.println("Lead Created");
				break;

}
		}
	}
}
