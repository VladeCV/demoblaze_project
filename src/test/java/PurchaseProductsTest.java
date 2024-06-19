import com.demoblaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.demoblaze.enums.MenuOption.*;


public class PurchaseProductsTest extends BaseTest {

    @Test(description = "Validate a correct purchase of products")
    public void testPurchaseProducts() {
        // DATA
        String productOne = "Apple monitor 24";
        String productTwo = "ASUS Full HD";

        // DATA USER PAYMENT
        String name = "Camilo Cabrera";
        String country = "Bolivia";
        String city = "La Paz";
        String card = "123456789";
        String month = "12";
        String year = "2023";

        //DATA USER ACCOUNT
//        String userName = "vbfgrt";
//        String password = "p2kkrosameeltrozo";
//        String userName = "asdas11";
//        String password = "asdwqda";
        String userName = "asdas16";
        String password = "asdwqda";

        //Crea cuenta
        menuPage.clickOnMenuOption(SING_UP);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accountPage.fillSignUpForm(userName, password);

        wait.waitAlert();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Inicia sesion
        menuPage.clickOnMenuOption(LOG_IN);
        accountPage.fillLoginForm(userName, password);

        // Selecciona categoria
//        driver.switchTo().defaultContent();

        // Selecciona la categoria de los productos
        monitorCategoryPage.selectMonitorCategory();

        // Click sobre el producto a comprar
        productPage.clickProductSelected(productOne);
        Assert.assertEquals(productOne, productDescriptionPage.getProductName(), "Name of products are different");

        // Añade el producto al carrito
        productDescriptionPage.clickAddToCartBtn();

        // Cierra la ventana de alerta
        wait.waitAlert();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Volvemos al home
        menuPage.clickOnMenuOption(HOME);

        // Selecciona categoria
        monitorCategoryPage.selectMonitorCategory();

        // Click sobre el producto a comprar
        productPage.clickProductSelected(productTwo);
        Assert.assertEquals(productTwo, productDescriptionPage.getProductName(), "Name of products are different");

        // Añade el producto al carrito
        productDescriptionPage.clickAddToCartBtn();

        // Cierra la ventana de alerta
        wait.waitAlert();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Entra al carrito de compras
        menuPage.clickOnMenuOption(CART);

        // Completa la compra
        cartPage.clickPlaceOrder();

        // Completa el formulario de pago
        paymentPage.fillPaymentForm(name, country, city, card, month, year);

        // Realiza la compra
        paymentPage.clickPurchase();

        Assert.assertEquals(confirmationPurchase.getConfirmationMessage(), "Thank you for your purchase!", "Error completing purchase");

        // Cierra la confirmacion de venta
        confirmationPurchase.clickConfirmation();


    }
}
