package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://leaftaps.com/opentaps/control/login");
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Demosalesmanager");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();
		WebElement link = driver.findElement(By.linkText("CRM/SFA"));
		link.click();
		WebElement btnContanct = driver.findElement(By.xpath("//a[text()='Contacts']"));
		btnContanct.click();
		WebElement merContact = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
		merContact.click();
		WebElement fContact = driver.findElement(By.xpath("(//img[@src=\"/images/fieldlookup.gif\"])[1]"));
		fContact.click();
		Set<String> winhand=driver.getWindowHandles();
		List<String> win=new ArrayList<String>(winhand);
		driver.switchTo().window(win.get(1));
		WebElement firContact = driver.findElement(By.xpath("(//div/a[@class=\"linktext\"])[1]"));
		firContact.click();
		//String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(win.get(0));
		WebElement toContact = driver.findElement(By.xpath("(//img[@src=\"/images/fieldlookup.gif\"])[2]"));
		toContact.click();
		Set<String> winhand1=driver.getWindowHandles();
		List<String> win1=new ArrayList<String>(winhand1);
		driver.switchTo().window(win1.get(1));
		WebElement secCont = driver.findElement(By.xpath("(//a[@class=\"linktext\"])[6]"));
		secCont.click();
		driver.switchTo().window(win1.get(0));
		WebElement btnMerge = driver.findElement(By.xpath("//a[text()='Merge']"));
		btnMerge.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println("the title is:"+title);
		if (title.contains("View")) {
			driver.quit();
		}
		
		
	}

}
