package org.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_Ec_001 {

	@Test
	public  void verifyRegistration() {
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Vijay");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("boopathy");
		driver.findElement(By.name("email")).sendKeys(generateEmail());
		driver.findElement(By.name("telephone")).sendKeys("6382174715");
		driver.findElement(By.id("input-password")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234567");
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String contentmessagecheck = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), contentmessagecheck);
		
		String actualcontentone = "Congratulations! Your new account has been successfully created!";
		String actualcontenttwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualcontentthree ="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualcontentfour ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		
		String exceptedcontent = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(exceptedcontent.contains(actualcontentone));
		Assert.assertTrue(exceptedcontent.contains(actualcontenttwo));
		Assert.assertTrue(exceptedcontent.contains(actualcontentthree));
		Assert.assertTrue(exceptedcontent.contains(actualcontentfour));
		
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}
	private String generateEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
		
		/*Date date = new Date();
		String datestring = date.toString();
		String nospacedatestring = datestring.replaceAll("\\s", "");
		String nospacedatecolumnstring = nospacedatestring.replaceAll("\\:", "");
		String emailtimestamp = nospacedatecolumnstring+"gmail.com";
		System.out.println(emailtimestamp);*/
		

	}
	
	
	
	
	
	
}
