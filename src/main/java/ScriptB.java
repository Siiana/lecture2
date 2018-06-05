import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptB {
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ScriptB.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

    public static void openItemsCatalog(WebDriver driver, String item, String itemName, String itemNamePrint, String itemNameCheck) {
        WebElement orders = driver.findElement(By.id(item));
        orders.click();
        WebElement ordersName = driver.findElement(By.className(itemName));
        System.out.println(itemNamePrint + ordersName.getText());
        driver.navigate().refresh();
        Boolean isPresent = driver.findElements(By.className(itemNameCheck)).size() > 0;
        System.out.println(isPresent);
    }

    public static void main(String[] args) {

        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("webinar.test@gmail.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement buttonSubmit = driver.findElement(By.name("submitLogin"));
        buttonSubmit.submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        openItemsCatalog(driver, "tab-AdminDashboard", "breadcrumb-current", "Dashboard:", "breadcrumb-current");
        openItemsCatalog(driver, "subtab-AdminParentOrders", "breadcrumb-container", "Заказы:", "breadcrumb-container");
        openItemsCatalog(driver, "subtab-AdminCatalog", "breadcrumb", "Каталог:", "breadcrumb");

        WebElement customer = driver.findElement(By.cssSelector("body > nav > ul > li:nth-child(5)"));
        customer.click();
        WebElement customerName = driver.findElement(By.className("breadcrumb-container"));
        System.out.println("Клиенты:" + customerName.getText());
        driver.navigate().refresh();
        Boolean itemNameCheck = driver.findElements(By.className("breadcrumb-container")).size() > 0;
        System.out.println(itemNameCheck);

        openItemsCatalog(driver, "subtab-AdminParentCustomerThreads", "breadcrumb-container", "Служба поддержки:", "breadcrumb-container");
        openItemsCatalog(driver, "subtab-AdminStats", "breadcrumb-container", "Статистика:", "breadcrumb-container");

        WebElement user = driver.findElement(By.id("employee_infos"));
        user.click();
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
        driver.quit();
    }
}


