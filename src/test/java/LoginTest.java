import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoblaze.enums.MenuOption.LOG_IN;

public class LoginTest extends BaseTest {

    @Test(description = "Validate login with empty credentials")
    public void tetLoginWithoutCredentials() {
        menuPage.clickOnMenuOption(LOG_IN);

        loginPage.clickOnLogin();

        wait.waitAlert();

        Assert.assertEquals(driver.switchTo().alert().getText(), "Please fill out Username and Password.");

    }
}
