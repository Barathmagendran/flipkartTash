package taskflipkart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlikartTask {
	static long start;
	static WebDriver driver;
	static String text;
	String text1;
	@BeforeClass
	public static void browserlaunch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SRITHAR\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.navigate().to("http://www.flipkart.com");
	}
	@AfterClass
	public static void quit() {
		driver.quit();
	}
	
	@Before
	public void startTime() {
	start = System.currentTimeMillis();
	}
	@After
	public void endTime() {
		long end = System.currentTimeMillis();
		System.out.println("total:"+(end-start));
	}
	@Test
	public void method1() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
}
	@Test
	public void method2() throws Throwable {
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("redmi mobiles");
		Robot r=new Robot();
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	@Test
	public void method3() throws Throwable {
		Thread.sleep(1000);
		WebElement mobile=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		text=mobile.getText();
		System.out.println("mobile name" +text);
		
	}
	@Test
	public void method4() throws Throwable {
			Thread.sleep(1000);
			WebElement mobile1=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
			mobile1.click();
			Thread.sleep(1000);
			WebElement mobile2=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
			mobile2.click();
			Thread.sleep(1000);
			WebElement mobile3=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
			mobile3.click();
	}
	@Test
	public void method5() throws Throwable {
		Set<String>parent=driver.getWindowHandles();
		List<String> child=new ArrayList<String>(parent);
		for(String x:child) {
		driver.switchTo().window(x);
		driver.switchTo().window(child.get(3));
		}
		WebElement get = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		 text1 = get.getText();
		System.out.println(text1);
		File f=new File("C:\\Users\\SRITHAR\\eclipse-workspace\\JunitTask\\src\\test\\resources\\flipkart.xlsx");
		HSSFWorkbook f1=new HSSFWorkbook();
		Sheet s=f1.createSheet();
		Row r = s.createRow(1);
		Cell c = r.createCell(0);
		c.setCellValue(text1);
		
		FileOutputStream f3=new FileOutputStream(f);
	f1.write(f3);
	
	}
	@Test
	public void method6() throws Throwable {
		TakesScreenshot tk=(	TakesScreenshot)driver;
		File src=tk.getScreenshotAs(OutputType.FILE);
			File des=new File("C:\\Users\\SRITHAR\\eclipse-workspace\\JunitTask\\src\\test\\resources\\ss");
			FileUtils.copyFile(src,des);
	}
	@Test
	public void meathod7() {
		if(text.equals(text1)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}
}
	
	
	
	
	
	
	
	