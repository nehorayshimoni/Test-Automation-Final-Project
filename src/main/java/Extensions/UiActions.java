package Extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Base;

import java.util.List;

public class UiActions extends Base {
    @Step("Click on Element")
    public static void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Update text: {text}")
    public static void updateText(WebElement element,String text){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    @Step("Get content of element")
    public static String getElementContent(WebElement element){

        if(element.getTagName().equals("input")){
            return element.getAttribute("value");
        }
        else{
            return element.getText();
        }
    }

    @Step("Print list content")
    public static void printListContent(List<WebElement> elements){
        for(WebElement element:elements ){
            System.out.println(element.getText());
        }
    }

    @Step("Get total number of elements")
    public static int getListTotal(List<WebElement> elements){
        return elements.size();
    }


    @Step("Search for item: {item}")
    public  static boolean searchForItem(List<WebElement> elements,String item){
        boolean isExist=false;
        for(WebElement element :elements){
            if(getElementContent(element).equalsIgnoreCase(item)){
                System.out.println(item +" exists in list");
                isExist=true;
                break;
            }
        }
        if(!isExist){
            System.out.println(item +" does not exist in list");
        }
        return isExist;
    }

    @Step("Click on item at index: {index}")
    public static void clickItemByIndex(List<WebElement> elements,int index){
        click( elements.get(index));

    }

    @Step("Navigate to URL {url}")
    public static void navigateToUrl(String url){
        driver.get(url);
    }

}
