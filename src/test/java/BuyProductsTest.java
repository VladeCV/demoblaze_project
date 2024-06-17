import com.demoblaze.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class BuyProductsTest extends BaseTest{

    @Test
    public void testBuyProducts() {
        // DATA
        String productOne = "Apple monitor 24";
        String productTwo = "ASUS Full HD";

        MonitorCategoryPage monitorCategoryPage = new MonitorCategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);
        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Selecciona categoria
        monitorCategoryPage.selectMonitorCategory();

        // Click sobre el producto a comprar
        productPage.clickProductSelected(productOne);
        Assert.assertEquals("Name of products are different", productOne, productDescriptionPage.getProductName());

        // Añade el producto al carrito
        productDescriptionPage.clickAddToCartBtn();

        // Cierra la ventana de alerta
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Volvemos al home
        menuPage.clickHomeLabel();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Selecciona categoria
        monitorCategoryPage.selectMonitorCategory();

        // Click sobre el producto a comprar
        productPage.clickProductSelected(productTwo);
        Assert.assertEquals("Name of products are different", productOne, productDescriptionPage.getProductName());

        // Añade el producto al carrito
        productDescriptionPage.clickAddToCartBtn();

        // Cierra la ventana de alerta
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Entra al carrito de compras
        menuPage.clickCartLabel();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Validamos si el carrito contiene productos
        cartPage.listCartProductsIsVisible();

        // Completa la compra
        cartPage.clickPlaceOrder();

        /*CONTINUAS CAMILO*/


    }
}
