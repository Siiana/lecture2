import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptB {
        public static void main (String[] args){
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
            WebElement orders = driver.findElement(By.id("subtab-AdminParentOrders"));
            orders.click();
            WebElement ordersName =driver.findElement(By.className("breadcrumb-container"));
            System.out.println("Заказы:" + ordersName.getText());
            driver.navigate().refresh();

            WebElement catalog = driver.findElement(By.id("subtab-AdminCatalog"));
            catalog.click();
            WebElement catalogName =driver.findElement(By.className("breadcrumb"));
            System.out.println("Каталог:" + catalogName.getText());
            driver.navigate().refresh();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement customer = driver.findElement(By.id("subtab-AdminParentCustomer"));
            customer.click();
            WebElement customerName =driver.findElement(By.className("breadcrumb-container"));
            System.out.println("Клиенты:" + customerName.getText());
            driver.navigate().refresh();

            WebElement customerThreads = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
            customerThreads.click();
            WebElement customerThreadsName =driver.findElement(By.className("breadcrumb-container"));
            System.out.println("Служба поддержки" + customerThreadsName.getText());
            driver.navigate().refresh();

            WebElement stats = driver.findElement(By.id("subtab-AdminStats"));
            stats.click();
            WebElement statsName =driver.findElement(By.className("breadcrumb-container"));
            System.out.println("Статистика" + statsName.getText());
            driver.navigate().refresh();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //WebElement user = driver.findElement(By.id("employee_infos"));
            //user.click();
            //WebElement logout = driver.findElement(By.id("header_logout"));
            //logout.click();
            driver.quit();
        }
        public static WebDriver initChromeDriver() {
            System.setProperty("webdriver.chrome.driver", ScriptA.class.getResource("chromedriver.exe").getPath());
            return  new ChromeDriver();
        }
    }


