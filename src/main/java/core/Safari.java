package core;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safari {
	static Properties p = new Properties();
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		Logger.getLogger("").setLevel(Level.OFF);
		
		System.out.println("Browser: Safari");
		System.out.println("===================================================");
		driver = new SafariDriver();
		driver.get(p.getProperty("url"));
		System.out.println("Page URI: " + driver.getCurrentUrl());
		System.out.println("Page title: " + driver.getTitle());
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 15000);
		
		// Enter First name
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("fname_id"))))
				.sendKeys(p.getProperty("fname_value"));
		// Enter Last name
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("lname_id"))))
				.sendKeys(p.getProperty("lname_value"));
		// Enter email
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("email_id"))))
				.sendKeys(p.getProperty("email_value"));
		// Enter phone number
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("phone_id"))))
				.sendKeys(p.getProperty("phone_value"));
		// Click on Submit button
		wait.until(ExpectedConditions.elementToBeClickable(By.id(p.getProperty("submit_id")))).click();
		
		System.out.println("===================================================");
		System.out.println("Page URI: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("First Name: " + driver.findElement(By.id(p.getProperty("fname_id"))).getText());
		System.out.println("Last Name: " + driver.findElement(By.id(p.getProperty("lname_id"))).getText());
		System.out.println("Email: " + driver.findElement(By.id(p.getProperty("email_id"))).getText());
		System.out.println("Phone: " + driver.findElement(By.id(p.getProperty("phone_id"))).getText());
		
		driver.quit();

	}

}
