package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    @FindBy(xpath = "//a[@href='/homes/']")
    public WebElement buyButton;




}
