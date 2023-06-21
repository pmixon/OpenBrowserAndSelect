
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class OpenBrowserAndSelect {

	//Instantiate a ChromeDriver class.
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Phillip says hello");
		
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
      
        
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*");
        	driver = new ChromeDriver(options);   

            // Maximize the browser
            driver.manage().window().maximize();
     
            // Launch Website
            driver.get("https://jqueryui.com/selectable/");
            
            WebElement iframe=driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframe);
            WebElement element1=driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
            WebElement element2=driver.findElement(By.xpath("//li[contains(text(),'Item 2')]"));
            Actions action=new Actions(driver);
            Action seriesOfActions = (Action) action.keyDown(Keys.CONTROL)
                    .click(element1)
                    .click(element2)
                    .build();
            seriesOfActions.perform();
            Thread.sleep(3000);
            
            // look for an element we know is not there
            WebElement testFailEle=driver.findElement(By.xpath("//li[contains(text(),'ItemFail 2')]"));
            assert testFailEle.isDisplayed() : "Element not found!";
               
	}
	
	public void teardown() {
		driver.close();
	}

}


