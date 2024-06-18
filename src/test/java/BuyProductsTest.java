import com.demoblaze.pages.*;
import org.junit.Assert;
import org.junit.Test;


public class BuyProductsTest extends BaseTest {

    @Test
    public void testBuyProducts() {
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
        String userName = "vbfgrt";
        String password = "p2kkrosameeltrozo";


        MonitorCategoryPage monitorCategoryPage = new MonitorCategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);
        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        CartPage cartPage = new CartPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        //Crea cuenta
        accountPage.clickSignUp();
        wait.implicitWait();
        accountPage.fillSignUpForm(userName, password);
        wait.waitAlert();
        driver.switchTo().alert().accept();

        // Inicia sesion
        accountPage.clickLogin();
        wait.implicitWait();
        accountPage.fillLoginForm(userName, password);

        // Selecciona categoria
        wait.implicitWait();
        driver.switchTo().defaultContent();
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

        // Completa el formulario de pago
        paymentPage.fillPaymentForm(name, country, city, card, month, year);

        // Realiza la compra
        paymentPage.clickPurchase();
        /*CONTINUAS CAMILO*/

        // Cierra la confirmacion de venta
        paymentPage.clickConfirmation();

        wait.implicitWait();


    }
}
