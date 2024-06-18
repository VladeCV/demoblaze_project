import com.demoblaze.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;
import util.PriceUtils;

import java.util.ArrayList;
import java.util.List;

public class ValidatePriceTest extends BaseTest {

    @Test
    public void testValidatePrice() {
        // DATA
        String productOne = "Samsung galaxy s6";
        String productTwo = "Nokia lumia 1520";

        List<Double> individualPrices = new ArrayList<>();

        // Click sobre el producto a comprar
        productPage.clickProductSelected(productOne);

        // Añadiendo el precio a la lista
        individualPrices.add(productDescriptionPage.getProductPrice());

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

        // Añadiendo el precio a la lista
        individualPrices.add(productDescriptionPage.getProductPrice());

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

        Assert.assertEquals("The prices are different", PriceUtils.sumPrices(individualPrices), cartPage.getTotalPrice());
    }
}
