package Extensions;

import io.qameta.allure.Step;
import org.testng.Assert;
import utilities.Base;

public class Verifications extends Base {
    @Step("Verify total={0}, actual,expected={1}")
    public static void verifyTotal(int actual, int expected){
        Assert.assertEquals(actual,expected);
    }

    @Step("Verify total={0}, actual,expected={1}")
    public static void verifyTotal(int actual, String expected){
        Assert.assertEquals(actual,Integer.parseInt(expected));
    }

    @Step("Verify Condition: condition={0}")
    public static void verifyTrue(boolean condition){
        Assert.assertTrue(condition);
    }

    @Step("Expect Condition {0} to be ture")
    public static void expectedTrue(boolean condition){
        softAssert.assertTrue(condition);
    }

    @Step("Expect Values to be equal")
    public static void expectEqual(int actual, int expected){
        softAssert.assertEquals(actual,expected);
    }

    @Step("Verify All Expectations")
    public static void verifyExpectations(){
        softAssert.assertAll();
    }

    @Step("Verify Title: actual={0}, expected={1}")
    public static void verifyText(String actual, String expected){
        Assert.assertEquals(actual,expected);
    }
    @Step("Verify Title: actual={0}, expected={1}")
    public static void expectText(String actual, String expected){
        softAssert.assertEquals(actual,expected);
    }
    @Step("Verify Price: actual={0}, expected={1}")
    public static void verifyPrice(double actual, double expected){
        Assert.assertEquals(actual,expected);
    }
    @Step("Verify Price: actual={0}, expected={1}")
    public static void verifyPrice(double actual, String expected){
        Assert.assertEquals(actual,Double.parseDouble(expected));
    }
    @Step("Verify Price: actual={0}, expected={1}")
    public static void expectPrice(double actual, double expected){
        softAssert.assertEquals(actual,expected);
    }
    @Step("Verify Price: actual={0}, expected={1}")
    public static void expectPrice(double actual, String expected){
        softAssert.assertEquals(actual,Double.parseDouble(expected));
    }
}
