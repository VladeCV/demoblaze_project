import com.demoblaze.helpers.JsonTestData;
import com.demoblaze.models.Products;
import com.demoblaze.pages.*;
import org.junit.Assert;
import com.demoblaze.util.PriceUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.demoblaze.enums.MenuOption.CART;
import static com.demoblaze.enums.MenuOption.HOME;

public class ValidatePriceTest extends BaseTest {

    public static String validatePriceDataPath = "resources/testdata/validatePrice/";

    @Test(description = "Validate if the sum of the price of the products is the same from the total price of the cart", dataProvider = "testValidatePriceDataProvider")
    public void testValidatePrice() {
        // DATA
        String productOne = "Samsung galaxy s6";
        String productTwo = "Nokia lumia 1520";


        List<Double> individualPrices = new ArrayList<>();

        ProductPage productPage1 = new ProductPage(driver);

        // Click sobre el producto a comprar
        productPage1.clickProductSelected(productOne);

        // Añadiendo el precio a la lista
        individualPrices.add(productDescriptionPage.getProductPrice());

        // Añade el producto al carrito
        productDescriptionPage.clickAddToCartBtn();

        // Cierra la ventana de alerta
        wait.waitAlert();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // Volvemos al home
        menuPage.clickOnMenuOption(HOME);

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
        menuPage.clickOnMenuOption(CART);

        Assert.assertEquals("The total sum of the prices of the products is different from the total price of the cart.", cartPage.getTotalPrice(), PriceUtils.sumPrices(individualPrices));
    }

    @DataProvider(name = "testValidatePriceDataProvider")
    public Object[] loginWithInvalidCredentialsDataProvider() throws FileNotFoundException {
        return JsonTestData.helper().getTestDataFromJason(validatePriceDataPath + "login-invalid-data.json", Products.class);
    }
}
