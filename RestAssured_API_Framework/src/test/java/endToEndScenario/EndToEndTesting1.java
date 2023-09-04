package endToEndScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import genericutility.JavaUtility;
import genericutility.WebActionUtility;


public class EndToEndTesting1 {
	WebActionUtility wLib = new WebActionUtility();
	JavaUtility jLib = new JavaUtility();
	static {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
	}

	@Test
	public void endToEnd() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        driver.findElement(By.name("projectName")).sendKeys("SMS"+jLib.getRandomNumber());
        RemoteWebDriver r = (RemoteWebDriver) driver;
        r.executeScript("document.getElementsByName(\"teamSize\").value='3'");
    //  driver.findElement(By.name("teamSize")).sendKeys("3");
        driver.findElement(By.name("createdBy")).sendKeys("Tharun");
        WebElement dropDown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
        wLib.selectByText(dropDown,"Created");
	    driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
       	
	
	
	
	}
}