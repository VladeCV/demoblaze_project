import com.demoblaze.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.demoblaze.util.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected Wait wait;

    protected MonitorCategoryPage monitorCategoryPage;
    protected ProductPage productPage;
    protected ProductDescriptionPage productDescriptionPage;
    protected MenuPage menuPage;
    protected CartPage cartPage;
    protected AccountPage accountPage;
    protected PaymentPage paymentPage;
    protected ConfirmationPurchase confirmationPurchase;
    protected LogInPage loginPage;

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
        accountPage = new AccountPage(driver);
        paymentPage = new PaymentPage(driver);
        confirmationPurchase = new ConfirmationPurchase(driver);
        loginPage = new LogInPage(driver);


        wait = new Wait(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
