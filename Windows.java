package Week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		getWindowCount(window);
		for(int i=0;i<windowHandles.size();i++)
		{
			System.out.println(window.get(i));
		}
		driver.switchTo().window(window.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button(text()='Do not close me']")).click();
		driver.findElement(By.xpath("//button(text()='Wait for 5 seconds']")).click();

}

	private static void getWindowCount(List<String> window) {
		// TODO Auto-generated method stub
		
	}
}
