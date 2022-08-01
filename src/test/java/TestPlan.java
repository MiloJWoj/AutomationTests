import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations. BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

        @Test(testName = "Cena złota")
        public static void submitForm () {
            driver.manage().window().maximize();
            driver.get(Utils.BASE_URL);
            driver.findElement(By.xpath("//*[text()='Akceptuję']")).click();

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebElement hoverElement =  driver.findElement(By.xpath("(//span[contains(text(), 'Rynki')])[1]"));
            executor.executeScript("arguments[0].scrollIntoView(true);", hoverElement);
            hoverElement.click();

            driver.findElement(By.xpath("//*[text()='Surowce']")).click();
            boolean eleSelected = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div[2]/div[2]/div[1]")).isDisplayed();
            System.out.println("Element displayed is :"+eleSelected);

            String str = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td/strong")).getText();
            System.out.println(str);

            driver.get(Utils.SECOND_URL);


        }

        @AfterSuite

        public static void cleanup () {

            driver.manage().deleteAllCookies();
            driver.close();
        }
    }
