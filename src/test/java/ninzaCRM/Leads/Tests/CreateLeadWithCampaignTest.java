package ninzaCRM.Leads.Tests;

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

import ninzaCRM.GenericUtilities.JavaUtility;

public class CreateLeadWithCampaignTest {
	@Test
	public void tc_01_createLeadWithCampaign() throws InterruptedException {
		// Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/");

		// Login to the application
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign In']")).click();

		// Click on create campaign
		driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
		String rAlphaNum = new JavaUtility().generateRandomAlphanumeric(4);
		// Create Campaign with mandatory details
		driver.findElement(By.name("campaignName")).sendKeys("Digital Media" + rAlphaNum);
		driver.findElement(By.name("targetSize")).sendKeys("2");
		driver.findElement(By.xpath("//button[.='Create Campaign']")).click();

		Thread.sleep(7000);

		// Navigate to Leads
		driver.findElement(By.linkText("Leads")).click();

		// click on create lead
		driver.findElement(By.xpath("//span[.='Create Lead']")).click();

		// Create lead with campaign
		driver.findElement(By.name("name")).sendKeys("Payal" + rAlphaNum);
		driver.findElement(By.name("company")).sendKeys("TCS" + rAlphaNum);
		driver.findElement(By.name("leadSource")).sendKeys("Marketing" + rAlphaNum);
		driver.findElement(By.name("industry")).sendKeys("IT" + rAlphaNum);
		driver.findElement(By.name("leadStatus")).sendKeys("Accepted");
		driver.findElement(By.name("phone")).sendKeys("9999742321");
		driver.findElement(By.name("rating")).sendKeys("3");

		// Navigate to campaign page
		driver.findElement(By.xpath("//*[local-name()='svg']/parent::button")).click();

		// Handle with window popup
		String mainWindID = driver.getWindowHandle();
		System.out.println(mainWindID);

		Set<String> allWinIds = driver.getWindowHandles();
		for (String winId : allWinIds) {
			if (!winId.equals(mainWindID)) {
				driver.switchTo().window(winId);
				System.out.println(winId);
				break;
			}
		}
		System.out.println("Switch from parent to child successful");

		// search for campaign in child window
		WebElement selDropdown = driver.findElement(By.id("search-criteria"));
		Select s = new Select(selDropdown);
		s.selectByVisibleText("Campaign Name");

		driver.findElement(By.id("search-input")).sendKeys("Digital Media" + rAlphaNum);
		driver.findElement(By.xpath("(//button[text()='Select'])[1]")).click();

		// switch the window control to main
		driver.switchTo().window(mainWindID);

		// Click on create lead
		driver.findElement(By.xpath("//button[.='Create Lead']")).click();

		// Validation
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='table table-" + "striped table-hover']/tbody/tr[*]/td[2]"));
		for (WebElement ele : list) {
			String leadInfo = ele.getText();
			if (leadInfo.equalsIgnoreCase("Payal")) {
				System.out.println(leadInfo);
				System.out.println("Lead added successfully");
				break;
			}
		}
		Thread.sleep(8000);
		
		//Logout
		WebElement ele = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		System.out.println("Logout Successfully");
		driver.quit();
	}
}
