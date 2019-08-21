import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsInAdmin {
    public static void main(String[] args) {
        WebDriver driver = DriverManager.getDriver("chrome");
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        WebElement loginInput = driver.findElement(By.id("email"));
        loginInput.sendKeys("webinar.test@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='subtab-AdminCatalog']")));

        WebElement adminCatalog = driver.findElement(By.xpath("//*[@id='subtab-AdminCatalog']"));
        WebElement adminCategories = driver.findElement(By.xpath("//*[@id='subtab-AdminCategories']"));

        Actions goToCategories = new Actions(driver);
        goToCategories.moveToElement(adminCatalog).pause(Duration.ofSeconds(5)).click(adminCategories).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-header-desc-category-new_category']")));

        WebElement addCategory = driver.findElement(By.xpath("//*[@id='page-header-desc-category-new_category']"));
        addCategory.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='name_1']")));

        WebElement inputNameCategory = driver.findElement(By.xpath("//*[@id='name_1']"));
        inputNameCategory.sendKeys("category1");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='category_form_submit_btn']"));
        js.executeScript("arguments[0].scrollIntoView();",saveButton);
        saveButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alert alert-success']")));

        WebElement createMessage = driver.findElement(By.xpath("//*[@class='alert alert-success']"));

        System.out.println("The text message is "+ createMessage.getText());

        WebElement findNameCategory = driver.findElement(By.xpath("//*[@name='categoryFilter_name']"));
        findNameCategory.sendKeys("category1");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='submitFilterButtoncategory']"));
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' odd']")));

        System.out.println("Found is "+ driver.findElement(By.xpath("//*[@class=' odd']")).getText());

        driver.quit();


    }


}
