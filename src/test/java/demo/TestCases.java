package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    Wrappers wrappers;

    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);
        wrappers = new Wrappers(driver);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        

        Thread.sleep(1000);

        By nameLocator = By.xpath("//div[@class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd']/div[1]/div[1]/div[1]/input");
        wrappers.sendKeys(nameLocator, "Crio Learner");

        By practicingAutomationLocator = By.xpath("//textarea[@class='KHxj8b tL9Q4c']");
        Long date = 1715515721L;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String convertedDate = sdf.format(new java.util.Date(date * 1000));
        wrappers.sendKeys(practicingAutomationLocator, "I want to be the best QA Engineer! " + convertedDate);

        wrappers.scroll(0, 500);

        wrappers.click(By.id("i22"));
        wrappers.click(By.id("i30"));
        wrappers.click(By.id("i33"));
        wrappers.click(By.id("i36"));
        wrappers.click(By.id("i39"));

        Thread.sleep(2000);

        By addressedLocator = By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']");
        wrappers.click(addressedLocator);
        Thread.sleep(2000);
        wrappers.click(By.xpath("//div[@role='option']//span[@class='vRMGwf oJeWuf'][normalize-space()='Mr']"));

        Thread.sleep(2000);

        wrappers.scroll(0, 900);
        Thread.sleep(2000);


        Actions actions = new Actions(driver);

        long timtam 
        = 1715515721L;
          
        
        long mlisec 
        = timtam * 1000;
        
    
        long neTimta
         = mlisec-(7*24*60*
        60*1000);
        
        Date newDte = new Date(neTimta);
        
        SimpleDateFormat sd   =        new
         SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String convertDate 
        = sd.format(newDte);

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='rFrNMe yqQS1 hatWr zKHdkd']")))
        
        .click().sendKeys("2024").sendKeys(Keys.ARROW_LEFT).sendKeys("06").sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(convertDate).click().perform();
        
        driver.findElement(By.xpath("//div[@class='A6uyJd']")).click();
        Thread.sleep(2000);




       

        wrappers.click(By.xpath("//div[@jscontroller='OZjhxc']"));

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedCurrentTime = currentTime.format(timeFormatter);

        actions.moveToElement(wrappers.findElement(By.xpath("//input[@aria-label='Hour']")))
               .click().sendKeys(formattedCurrentTime.split(":")[0])
               .sendKeys(Keys.TAB).sendKeys(formattedCurrentTime.split(":")[1])
               .sendKeys(Keys.TAB).perform();

        Thread.sleep(2000);

        By submitButtonLocator = By.xpath("//span[contains(text(),'Submit')]");
        WebElement submitButton = wrappers.findElement(submitButtonLocator);
        System.out.println("Submit button text: " + submitButton.getText());

        submitButton.click();
        Thread.sleep(2000);

        System.out.println("Thanks for your response, Automation Wizard!");
        System.out.println("End Test case: testCase01");
    }
}
