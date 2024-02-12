package POM;

import org.openqa.selenium.By;
import lombok.Data;
@Data
public final class LoginPOM {

    public LoginPOM() {

    }

    private final By emailField = By.xpath("(//input[@id='email'])[1]");

    private final By passwordField = By.xpath("//input[@id='login-password']");

    private final By submitBtn = By.xpath("(//button[@id='send2'])[1]");

    private final By userLogo = By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div[2]/div/div[1]/a/span[1]");

    private final By username = By.xpath("//span[contains(text(),'Əlaqə məlumatı')]");

    private final By daxilOlBtn = By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div[2]/div/div[1]/a/span[1]");

    private final By registerBtn = By.className("signup");

    private final By registerName = By.xpath("//input[@id='firstname']");

    private final By registerSurname = By.xpath("//input[@id='lastname']");

    private final By registerEmail = By.xpath("(//input[@id='email_address'])[1]");

    private final By registerPassword = By.xpath("//input[@id='register-password']");

    private final By registerPasswordConfirm = By.xpath("//input[@id='register-password-confirmation']");

    private final By registerSubmit = By.xpath("//span[normalize-space()='Yeni hesab yaratmaq']");

}
