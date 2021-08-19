package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomesForSalePage extends PageBase{

//    @FindBy(xpath = "//input[@placeholder='Address, neighborhood, or ZIP']")
//    public WebElement locationField;

    @FindBy(xpath = "//div[@id='srp-search-box']")
    public WebElement locationField;



    @FindBy(id = "price")
    public WebElement priceButton;

    @FindBy(xpath = "//label[@for='price-exposed-min']")
    public WebElement priceMinField;

    @FindBy(xpath = "//label[@for='price-exposed-max']")
    public WebElement priceMaxField;



}
