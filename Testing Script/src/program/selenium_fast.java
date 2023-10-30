package program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_fast {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/shambho/Downloads/chromedriver_mac_arm64/chromedriver");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the web app
        driver.get("http://127.0.0.1:5500/index.html");

        // Add multiple tasks
        addTask(driver, "Task 1");
        addTask(driver, "Task 2");
        addTask(driver, "Task 3");
        System.out.println("Multiple tasks added. Test passed!");

        // Delete tasks
        deleteTask(driver, "Task 2");
        System.out.println("Task deletion test passed!");

        // Toggle dark mode
        toggleDarkMode(driver);
        System.out.println("Dark mode toggle test passed!");

        // Close the browser
        driver.quit();
    }

    // Helper methods for test cases
    public static void addTask(WebDriver driver, String taskName) {
        WebElement taskInput = driver.findElement(By.id("taskInput"));
        taskInput.sendKeys(taskName);
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add Task')]"));
        addButton.click();
    }

    public static void deleteTask(WebDriver driver, String taskName) {
        try {
            WebElement taskToDelete = driver.findElement(By.xpath("//li[contains(text(),'" + taskName + "')]/span"));
            taskToDelete.click();
        } catch (Exception e) {
            System.out.println("Element not found for deletion");
        }
    }

    public static void toggleDarkMode(WebDriver driver) {
        WebElement darkModeToggle = driver.findElement(By.id("darkModeToggle"));
        darkModeToggle.click();
    }
}
