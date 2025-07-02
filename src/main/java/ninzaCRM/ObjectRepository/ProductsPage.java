package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath = "//span[.='Add Product']")
	private WebElement addProductBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> ProductNamesTxt;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddProductBtn() 
	{
		return addProductBtn;
	}

	public List<WebElement> getProductNamesTxt() 
	{
		return ProductNamesTxt;
	}
	
	//Business Library
	
	/**
	 * This method will click on add product button
	 */
	
	public void clickOnAddProductBtn()
	{
		addProductBtn.click();
	}
	
	/**
	 * This method will capture all the product names and compare with required product Name
	 * @param RequiredProductName
	 * @throws InterruptedException
	 */
	
	public void captureProductNamesAndCompare(String RequiredProductName) throws InterruptedException
	{
		for (WebElement element : ProductNamesTxt) {
			 
			String ProductName = element.getText();
			if(ProductName.equals(RequiredProductName))
			{
				System.out.println(ProductName+" Lead Created Successfully");
				Thread.sleep(8000);
				break;
			}
		}
	}

}
