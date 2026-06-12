package prac;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiniPjt {
	static WebDriver driver;
    static WebElement ele;
    
    static void driverSetup(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    static void productClick(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    static void enterText(String locator, String txt) {
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(txt);
    }	
    
    static void takeScreenshot(String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\Porkodi\\eclipse-workspace\\selepractice\\Screenshot\\"+ name+".png");
        FileUtils.copyFile(src, dest);
    }

	public static void main(String[] args) throws IOException {
		driverSetup("https://petstore.octoperf.com/actions/Catalog.action");
        takeScreenshot("snapshot1"); //Home page

        productClick("img[src='../images/birds_icon.gif']");
        takeScreenshot("snapshot2"); //Birds category

        productClick("a[href*='productId=AV-CB-01']");
        takeScreenshot("snapshot3"); //Amazon parrot

        productClick("a[href*='workingItemId=EST-18']");
        takeScreenshot("snapshot4"); //Add to cart

        enterText("input[name='EST-18']", "2");
        productClick("input[value='Update Cart']");
        takeScreenshot("snapshot5"); //Update cart

        productClick("a[href*='newOrderForm']");
        takeScreenshot("snapshot6"); //Login page

        driver.quit();
    }

	}
