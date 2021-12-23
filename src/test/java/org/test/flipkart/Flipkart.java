package org.test.flipkart;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			Scanner s = new Scanner(System.in);

			driver.get("https://www.flipkart.com/");
			WebElement close = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			close.click();
			WebElement Searchbox = driver.findElement(By.xpath("//input[@name='q']"));
			Searchbox.sendKeys("iphone 11 pro");
			WebElement Searchbtn = driver.findElement(By.xpath("//button[@type='submit']"));

			Searchbtn.click();

			WebElement product1 = driver.findElement(By.xpath("//div[@class='_4rR01T'][1]"));
			product1.click();

			String id1 = driver.getWindowHandle();

			System.out.println(id1);
			Set<String> Allid = driver.getWindowHandles();
			System.out.println(Allid);

			for (String eachid : Allid) {
				if (!id1.equals(Allid))
					driver.switchTo().window(eachid);

			}
			for (String eachid1 : Allid) {
				int count = 1;
				if (count == 2) {
					driver.switchTo().window(eachid1);

				}
				System.out.println("Count");
				count++;
			}
			WebElement pricecheck = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']"));

			String check = pricecheck.getText();
			System.out.println(check);
			String c1 = null;
			String c2 = null;
			if (check.contains("₹")) {
				c1 = check.replace("₹", "");
				System.out.println(c1);

			}
			if (c1.contains(",")) {
				c2 = c1.replace(",", "");
				System.out.println(c2);

			}

			Integer i = Integer.parseInt(c2);

			System.out.println(i);
			if (i == s.nextInt()) 
			{

				System.out.println("Done");
			}
			 else {
				System.out.println("invalid");
				

			}

		}
	}



