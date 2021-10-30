package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snow {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev31494.service-now.com/login_redirect.do?sysparm_stack=no");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement eleUser = driver.findElement(By.xpath("//input[@id=\"user_name\"]"));
		eleUser.sendKeys("admin");
		WebElement elePwd = driver.findElement(By.xpath("//input[@id=\"user_password\"]"));
		elePwd.sendKeys("Rane@456");
		WebElement btnLogin = driver.findElement(By.xpath("//button[@id=\"sysverb_login\"]"));
		btnLogin.click();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(80));
		WebElement Ser = driver.findElement(By.xpath("//span[text()='Self-Service']"));
		w.until(ExpectedConditions.visibilityOf(Ser));
		WebElement eleFil = driver.findElement(By.xpath("//input[@id=\"filter\"]"));
		eleFil.sendKeys("incident");
		WebElement eleAll = driver.findElement(By.xpath("//a[@id=\"b55b4ab0c0a80009007a9c0f03fb4da9\"]//div[text()='All']"));
		eleAll.click();
		driver.switchTo().frame(0);
		WebElement btnNew = driver.findElement(By.xpath("//button[@id=\"sysverb_new\"]"));
		btnNew.click();
		WebElement eleCal = driver.findElement(By.xpath("//input[@data-name=\"caller_id\"]"));
		eleCal.clear();
		WebElement eleLook = driver.findElement(By.xpath("//span[@class=\"icon icon-search\"]"));
		eleLook.click();
		
		//		eleCal.click();
//		WebElement eleSer = driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']"));
//		eleSer.click();
		Set<String> s=driver.getWindowHandles();
		List<String> wi=new ArrayList<String>(s);
		driver.switchTo().window(wi.get(1));
		WebElement eleSer = driver.findElement(By.xpath("(//input[@placeholder=\"Search\"])[1]"));
		eleSer.sendKeys("System");
		eleSer.sendKeys(Keys.ENTER);
		WebElement sel = driver.findElement(By.xpath("//a[text()='System Administrator']"));
		sel.click();
		Set<String> s1=driver.getWindowHandles();
		List<String> w1=new ArrayList<String>(s1);
		driver.switchTo().window(w1.get(0));
		driver.switchTo().frame(0);
		WebElement eleSDes = driver.findElement(By.xpath("//input[@aria-label=\"Short description\"]"));
		eleSDes.sendKeys("testing site");
		WebElement eleIncNo = driver.findElement(By.xpath("//input[@id=\"incident.number\"]"));
		String incNo = eleIncNo.getAttribute("value");
		System.out.println("The incident Number is:"+incNo);
		WebElement eleSub = driver.findElement(By.id("sysverb_insert"));
		eleSub.click();
		WebElement eleSr = driver.findElement(By.xpath("//span[contains(text(),' submit the search')]/following-sibling::input"));
		eleSr.sendKeys(incNo);
		eleSr.sendKeys(Keys.ENTER);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst =new File("./snap/pic1.png");
		FileUtils.copyFile(src, dst);
		}
}
