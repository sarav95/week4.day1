package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCher {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement fText = driver.findElement(By.xpath("//span[text()='Not a Friendly Topic']"));
		String text = fText.getText();
		WebElement fra1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(fra1);
		WebElement t1 = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		t1.sendKeys(text);
		WebElement fra3 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(fra3);
		WebElement check = driver.findElement(By.id("a"));
		check.click();
		driver.switchTo().defaultContent();
		WebElement fra2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(fra2);
		WebElement Sel = driver.findElement(By.id("animals"));
		Select drop =new Select(Sel);
		drop.selectByIndex(3);
		Thread.sleep(60);
		driver.quit();	
	}

}
