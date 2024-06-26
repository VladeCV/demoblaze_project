import com.aventstack.extentreports.Status;
import com.demoblaze.helpers.ReportManager;
import com.demoblaze.helpers.ScreenShotHelper;
import com.demoblaze.pages.*;
import com.demoblaze.util.Scroll;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.demoblaze.util.Wait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static com.demoblaze.webdriver.WebDriverFactory.getDriver;

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
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public static void setupSuite() throws Exception {
        ReportManager.init("Reports", "DemoBlazeAutomation");
    }

    @BeforeMethod
    @Parameters({"url", "browser"})
    public void setup(Method method, String url, String browser) throws Exception {
        ReportManager.getInstance().startTest(method.getName());

        driver = getDriver(browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

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
        log.info("Navigate to {}", url);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Navigate to Demoblaze page");

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        try {
            switch (iTestResult.getStatus()) {
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incompleto");
            }

            if (iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null) {
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.FAIL, "Failure image");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(1000);
            if (driver != null)
                driver.quit();
            log.info("Closing the webdriver");
        }
    }

    @AfterSuite
    public static void tearDownSuite() {
        ReportManager.getInstance().flush();
    }

}
