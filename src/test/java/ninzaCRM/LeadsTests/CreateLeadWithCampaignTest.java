package ninzaCRM.LeadsTests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadWithCampaignTest {
	
	@Test
	public void tc_01_createLeadWithCampaign() throws InterruptedException
	{
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the URL
		driver.get("http://49.249.28.218:8098/");
		
		//Login to application
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		
		//Click on create campaign
		driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
		
		//Create campaign with mandatory fields
		driver.findElement(By.name("campaignName")).sendKeys("DigitalIndia_100");
		driver.findElement(By.name("targetSize")).sendKeys("2");
		driver.findElement(By.xpath("//button[.='Create Campaign']")).click();
		
		Thread.sleep(7000);
		
		//Navigate to Leads
		driver.findElement(By.xpath("//a[.='Leads']")).click();
		
		//Click on create lead
		driver.findElement(By.xpath("//span[.='Create Lead']")).click();
		
		//Create lead with campaign
		driver.findElement(By.name("name")).sendKeys("Arijeet-1");
		driver.findElement(By.name("company")).sendKeys("TCS");
		driver.findElement(By.name("leadSource")).sendKeys("Marketting");
		driver.findElement(By.name("industry")).sendKeys("IT");
		driver.findElement(By.name("phone")).sendKeys("9898765678");
		driver.findElement(By.name("leadStatus")).sendKeys("Accepted");
		driver.findElement(By.name("rating")).sendKeys("5");
		
		//Navigate to campaign page
		driver.findElement(By.xpath("//*[local-name()='svg']/parent::button")).click();
		
		//Handle window pop-up
		String mainWinID = driver.getWindowHandle();
		System.out.println(mainWinID);
		
		Set<String> allWinIds = driver.getWindowHandles();
		
		for(String winID:allWinIds)
		{
			if(!winID.equals(mainWinID))
			{
				driver.switchTo().window(winID);
				System.out.println(winID);
				break;
			}
		}
		
		System.out.println("Switch from parent to child successfull.");
		
		//Search for campaign in child window
		WebElement selDropDown = driver.findElement(By.id("search-criteria"));
		Select s = new Select(selDropDown);
		s.selectByVisibleText("Campaign Name");
		
		driver.findElement(By.id("search-input")).sendKeys("DigitalIndia_100");
		driver.findElement(By.xpath("//td[.='DigitalIndia_100']/following-sibling::td/child::button")).click();
		
		//Switch the window control to main
		driver.switchTo().window(mainWinID);
		
		//Click on create lead
		driver.findElement(By.xpath("//button[.='Create Lead']")).click();
		
		//Validation
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]"));
		for(WebElement ele : list)
		{
			String leadInfo = ele.getText();
			if(leadInfo.equalsIgnoreCase("Arijeet-1"))
			{
				System.out.println(leadInfo);
				System.out.println("Lead created successfully");
				break;
			}
		}
		
		Thread.sleep(8000);
		
		//Logout
		WebElement ele = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dropdown-item loogout']")).click();
		
		System.out.println("Logout Successfull.");
	}

}
