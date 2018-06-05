import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptA {
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ScriptA.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
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
        WebElement user = driver.findElement(By.id("employee_infos"));
        user.click();
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
        driver.quit();
    }
}
