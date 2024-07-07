package SauceDemoTests;


import Extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Base;
import org.testng.annotations.BeforeClass;
import workFlows.WebFlows;

@Listeners(utilities.Listeners.class)
public class TestStore extends Base {

    @BeforeClass
    public void initWeb() {
        WebFlows.signIn(getDataFromXml("USERNAME"), getDataFromXml("PASSWORD"));
    }


    @Test(description = "Test - Verify Total Products")
    @Description("This test verify the total products is expected")
    public void test01verifyTotalProducts() {
        WebFlows.printTotalProducts();
        Verifications.verifyTotal(WebFlows.getTotalProducts(), getDataFromXml("EXPECTED_TOTAL_PRODUCTS"));
    }

    @Test(description = "Test - Verify Product exist in list")
    @Description("This test verify a product exist in list")
    public void test02verifyProductsExist() {
        Verifications.expectedTrue(WebFlows.isExist("Sauce Labs Backpack"));
        Verifications.expectedTrue(WebFlows.isExist("Sauce Labs Bike Light"));
        Verifications.expectedTrue(WebFlows.isExist("Sauce Labs Bolt T-Shirt"));
        Verifications.expectedTrue(WebFlows.isExist("Sauce Labs Fleece Jacket"));
        Verifications.expectedTrue(WebFlows.isExist("Sauce Labs Onesie"));
        Verifications.expectedTrue(WebFlows.isExist("Test.allTheThings() T-Shirt (Red)"));
        Verifications.verifyExpectations();
    }

    @Test(description = "Test - Verify Item Page")
    @Description("This test verifies access to the right item page")
    public void test03verifyItemPage() {
        WebFlows.navigateToProductByIndex(getDataFromXml("BACKPACK_ID"));
        Verifications.expectText(WebFlows.getProductTitle(), getDataFromXml("EXPECTED_PRODUCT_TITLE"));
        Verifications.verifyExpectations();
    }

    @Test(description = "Test - Verify Access to all Item Pages", dataProviderClass = Base.class, dataProvider = "productsData")
    @Description("This test verifies access to all item pages")
    public void test04verifyAccessItemPage(int productIndex, String expectText) {
        WebFlows.goList();
        WebFlows.navigateToProductByIndex(productIndex);
        Verifications.verifyText(WebFlows.getButtonText(), expectText);
    }
}

