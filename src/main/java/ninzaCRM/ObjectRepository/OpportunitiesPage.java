package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	@FindBy(xpath = "//span[.='Create Opportunity']")
	private WebElement createOpportunityBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> OpportunityNameTxt;
	
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}

	public List<WebElement> getOpportunityNameTxt() {
		return OpportunityNameTxt;
	}
	
	//Business Library
	
	/**
	 * This method will click on create opportunity button
	 */
	
	public void clickOnCreateOpportunityBtn()
	{
		createOpportunityBtn.click();
	}
	
	
	
	public void captureOpportunityNameAndCompare(String RequiredOpportunityName) throws InterruptedException
	{
		for(WebElement element : OpportunityNameTxt)
		{
			String OpportunityName = element.getText();
			if(OpportunityName.equals(RequiredOpportunityName))
			{
				System.out.println(OpportunityName+" Opportunity Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}

}
