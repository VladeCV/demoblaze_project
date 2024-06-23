import com.demoblaze.pages.*;
import com.demoblaze.util.Scroll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.demoblaze.util.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected Wait wait;
    protected Scroll scroll;
    protected MonitorCategoryPage monitorCategoryPage;
    protected ProductPage productPage;
    protected ProductDescriptionPage productDescriptionPage;
    protected MenuPage menuPage;
    protected CartPage cartPage;
    protected PaymentPage paymentPage;
    protected ConfirmationPurchase confirmationPurchase;
    protected LogInPage loginPage;
    protected SignUpPage signUpPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/");

        monitorCategoryPage = new MonitorCategoryPage(driver);
        productPage = new ProductPage(driver);
        productDescriptionPage = new ProductDescriptionPage(driver);
        menuPage = new MenuPage(driver);
        cartPage = new CartPage(driver);
        paymentPage = new PaymentPage(driver);
        confirmationPurchase = new ConfirmationPurchase(driver);
        loginPage = new LogInPage(driver);
        signUpPage = new SignUpPage(driver);

        scroll = new Scroll(driver);
        wait = new Wait(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
