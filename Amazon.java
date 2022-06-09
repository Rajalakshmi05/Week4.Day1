package Week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro" + "\n");
		String fprice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The First Item Price is: " + fprice);
		String frating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("The First Item Customer Rating is: " + frating);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.id("add-to-cart-button")).click();
		String acart = driver.findElement(By.xpath("(//div[@id='attach-added-to-cart-message']//span/span)[2]"))
				.getText();
		System.out.println("The Cart Total is: " + acart);
		if (fprice == acart) {
			System.out.println("The cart Subtotal is verified");
		} else {
			System.out.println("The cart Subtotal is Wrong");
		}

		File source = driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./AmazonScreen.png");
		FileUtils.copyFile(source, Dest);
		driver.quit();

	}

}
