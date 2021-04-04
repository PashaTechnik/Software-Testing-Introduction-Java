package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    @FindBy(className = "ScCoreButtonPrimary-sc-1qn4ixc-1")
    private WebElement registrationButton;

    @FindBy(xpath = "//*[@id=\"signup-username\"]")
    private WebElement registrationNameField ;

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div[1]/div/div/div[3]/form/div/div[1]/div/div[3]/div/div/p")
    private WebElement errorCharactersField;


    public void goToLogin(){
        registrationButton.click();
    }

    public void inputLogin(String login) {
        registrationNameField.sendKeys(login);
    }

    public String getError() {
        return errorCharactersField.getText();
    }
}