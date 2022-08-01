import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations. BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

        @Test(testName = "Submit a WebForm")
        public static void submitForm () {
            driver.manage().window().maximize();
            driver.get(Utils.BASE_URL);
            WebForm webForm = new WebForm(driver);
            driver.findElement(By.xpath("//*[text()='Akceptuję']")).click();
            Actions action = new Actions(driver);

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebElement hoverElement =  driver.findElement(By.xpath("(//span[contains(text(), 'Rynki')])[1]"));
            executor.executeScript("arguments[0].scrollIntoView(true);", hoverElement);
            hoverElement.click();

            driver.findElement(By.xpath("//*[text()='Surowce']")).click();
            boolean eleSelected= driver.findElement(By.xpath("//html/body/div[3]/div[1]/div[2]/div[2]/div[1]")).isDisplayed();
            System.out.println("Element displayed is :"+eleSelected);
        }

        @AfterSuite

        public static void cleanup () {

            driver.manage().deleteAllCookies();
            driver.close();
        }
    }
