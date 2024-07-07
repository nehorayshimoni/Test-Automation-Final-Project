package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    public WebElement productTitle;

    @FindBy(xpath = "//button[@id='back-to-products']")
    public WebElement backToProductsButton;
}
