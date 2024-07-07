package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ItemPage;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;

    //Page Objects -WEB
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static ItemPage itemPage;


    @BeforeSuite
    public void setup() throws Exception {
        String browserType = getDataFromXml("BROWSER_TYPE");
        initBrowser(browserType);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXml("SLEEP_TIMEOUT")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(getDataFromXml("WAIT_TIMEOUT")));
        driver.get(getDataFromXml("URL"));
        action = new Actions(driver);
        softAssert = new SoftAssert();
        initStorePages();
    }

    @AfterSuite
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(Long.parseLong(getDataFromXml("SLEEP_TIMEOUT")), TimeUnit.SECONDS);
        if (driver != null) {
            driver.quit();
        }
    }

    private void initBrowser(String browserType) throws Exception {
        if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Unsupported Browser was provided...!");
        }
    }

    public static String getDataFromXml(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("files/configuration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    private void initStorePages(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        itemPage = new ItemPage(driver);
    }

    @DataProvider
    public Object[][] productsData(){
        return new Object[][]{
                {0, "Back to products"},
                {1, "Back to products"},
                {2, "Back to products"},
                {3, "Back to products"},
                {4, "Back to products"},
                {5, "Back to products"},
        };
    }
}