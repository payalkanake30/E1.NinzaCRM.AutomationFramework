package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(xpath= "//span[.='Create Lead']")
	private WebElement createLeadBtn;
	
	@FindBy(xpath="//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> LeadNamesTxt;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateLeadBtn() {
		 return createLeadBtn;
	}
	
	/**
	 * This method will click on create lead button
	 */
	public void clickOnCreateLeadBtn()
	{
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
