package selenium_framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class BasicScript {
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Title of page is :" + pageTitle);
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Praveen");
		driver.findElement(By.id("LastName")).sendKeys("Kumar");
		WebElement emailId = driver.findElement(By.id("Email"));
		int randomNum = (int) (Math.random() * 100);
		String email = "praveen" + randomNum + "@mailinator.com";
		emailId.sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys("Password@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Password@123");
		driver.findElement(By.id("register-button")).click();
		String actualText = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"))
				.getText();
		Assert.assertEquals(actualText, "Your registration completed");
		driver.close();

	}
}
