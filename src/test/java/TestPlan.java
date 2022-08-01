import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations. BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
            String stringgg = str.replace(',','.');
            System.out.println(stringgg);


            driver.get(Utils.SECOND_URL);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            String strin=driver.findElement(By.xpath("(//*[@class='line'])[4]")).getText();
            String stringg = strin.replaceFirst("<Cena>","");
            String st = stringg.replaceFirst("</Cena>","");

            String fullstri = st.trim();
            System.out.println(fullstri);

            System.out.println(fullstri==stringgg);
    }

        @AfterSuite

        public static void cleanup () {

            driver.manage().deleteAllCookies();
            driver.close();
        }
    }
