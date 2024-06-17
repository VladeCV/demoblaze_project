import com.demoblaze.pages.MonitorCategoryPage;
import com.demoblaze.pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;

public class GoToMonitorCategoryTest extends BaseTest {
    @Test
    public void testGoToMonitorCategory() {
        MonitorCategoryPage categoryPage = new MonitorCategoryPage(driver);

        categoryPage.selectMonitorCategory();

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue("Products are not visible", productPage.listProductsIsVisible());

    }
}
