import com.demoblaze.pages.*;
import org.junit.Assert;
import org.junit.Test;


public class BuyProductsTest extends BaseTest{

    @Test
    public void testBuyProducts() {
        // DATA
        String productOne = "Apple monitor 24";
        String productTwo = "ASUS Full HD";

        // Selecciona categoria
        monitorCategoryPage.selectMonitorCategory();

        // Click sobre el producto a comprar
        productPage.clickProductSelected(productOne);
        Assert.assertEquals("Name of products are different", productOne, productDescriptionPage.getProductName());

        // Añade el producto al carrito
        productDescriptionPage.clickAddToCartBtn();

        // Cierra la ventana de alerta
        wait.waitAlert();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Volvemos al home
        menuPage.clickHomeLabel();

        wait.implicitWait();

        // Selecciona categoria
        monitorCategoryPage.selectMonitorCategory();

        // Click sobre el producto a comprar
        productPage.clickProductSelected(productTwo);
        Assert.assertEquals("Name of products are different", productTwo, productDescriptionPage.getProductName());

        // Añade el producto al carrito
        productDescriptionPage.clickAddToCartBtn();

        // Cierra la ventana de alerta
        wait.waitAlert();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Entra al carrito de compras
        menuPage.clickCartLabel();

        wait.implicitWait();

        // Validamos si el carrito contiene productos
        cartPage.listCartProductsIsVisible();

        // Completa la compra
        cartPage.clickPlaceOrder();

        /*CONTINUAS CAMILO*/


    }
}
