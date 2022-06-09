package Week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement eleUserName = driver .findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img[@alt='Lookup']")).click();
		Set<String> windowHandling = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandling);
		driver.switchTo().window(winList.get(1));
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winList1.get(1));
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Title : "+driver.getTitle());

		driver.close();
		
	}

}
