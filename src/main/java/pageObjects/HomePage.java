package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    public List<WebElement> inventoryTitles;

    @FindBy(xpath = "//img[@class='inventory_item_img']")
    public List<WebElement> inventoryPictures;
}
