import com.demoblaze.pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Wait;

public class BaseTest {

    protected WebDriver driver;
    protected Wait wait;

    protected MonitorCategoryPage monitorCategoryPage;
    protected ProductPage productPage;
    protected ProductDescriptionPage productDescriptionPage;
    protected MenuPage menuPage;
    protected CartPage cartPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        monitorCategoryPage = new MonitorCategoryPage(driver);
        productPage = new ProductPage(driver);
        productDescriptionPage = new ProductDescriptionPage(driver);
        menuPage = new MenuPage(driver);
        cartPage = new CartPage(driver);

        wait = new Wait(driver);
    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null)
            driver.quit();
    }
}
