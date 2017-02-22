package tests;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Anastasiya on 21.02.2017.
 */
public class ShortTask {

    public static void implementation() {
        shortTask1();
        shortTask2();
        shortTask3();
        shortTask4();
        shortTask5();
        shortTask6();
    }

    private static void shortTask1() {
        WebDriver driverFireFox = new FirefoxDriver();
        String urlGoogle = "https://www.google.com/";
        String pageTitle;
        String currentUrl;
        int titleLength;
        int pageSourceLength;

        driverFireFox.get(urlGoogle);
        pageTitle = driverFireFox.getTitle();
        titleLength = driverFireFox.getTitle().length();
        System.out.println("pageTitle = " + pageTitle);
        System.out.println("titleLength = " + titleLength);

        currentUrl = driverFireFox.getCurrentUrl();//??
        if (currentUrl.equals(urlGoogle)) {
            System.out.println("url verify");
        } else {
            System.out.println("url not verify");
        }
        driverFireFox.getPageSource();
        pageSourceLength = driverFireFox.getPageSource().length();
        System.out.print("page sourse length = " + pageSourceLength);
        driverFireFox.close();
    }

    private static void shortTask2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.navigate().to("https://www.google.com.ua/search?q=w3");
        driverChrome.findElement(By.xpath(".//div/div/div[1]/div/h3/a")).click();
        driverChrome.navigate().back();
        driverChrome.navigate().forward();
        driverChrome.navigate().refresh();
        driverChrome.close();
    }

    private static void shortTask3() {
        WebDriver driverFireFox = new FirefoxDriver();
        driverFireFox.get("http://toolsqa.wpengine.com/automation-practice-form/");
        WebElement elementName = driverFireFox.findElement(By.name("firstname"));
        WebElement elementLastName = driverFireFox.findElement(By.name("lastname"));
        elementName.sendKeys("Name");
        elementLastName.sendKeys("Last name");
        WebElement elementButton = driverFireFox.findElement(By.id("submit"));
        elementButton.click();
        driverFireFox.close();
    }

    private static void shortTask4() {
        WebDriver driverFireFox = new FirefoxDriver();
        driverFireFox.get("http://toolsqa.wpengine.com/automation-practice-form/");
        WebElement elementLink = driverFireFox.findElement(By.partialLinkText("Partial"));
        elementLink.click();

        WebElement elementButton = driverFireFox.findElement(By.tagName("button"));
        System.out.println(elementButton.toString());
        System.out.println(elementButton.getText());

        WebElement elementLinkTest = driverFireFox.findElement(By.linkText("Link Test"));
        elementLinkTest.click();
        driverFireFox.close();
    }

    private static void shortTask5() {
        WebDriver driverFireFox = new FirefoxDriver();
        driverFireFox.get("http://toolsqa.wpengine.com/automation-practice-form/");

        WebElement radioButtonFemale = driverFireFox.findElement(By.id("sex-1"));
        radioButtonFemale.click();

        List<WebElement> yearsOfExp = driverFireFox.findElements(By.name("exp"));
        for (WebElement element : yearsOfExp) {
            String third = "3";
            String sValue = element.getAttribute("value");
            if (sValue.equalsIgnoreCase(third)) {
                element.click();
            }
        }

        WebElement checkBoxAutomation = driverFireFox.findElement(By.id("profession-1"));
        System.out.println("checkBoxAutomation = " + checkBoxAutomation.isSelected());
        WebElement checkBoxSelenium = driverFireFox.findElement(By.cssSelector("#tool-1"));
        checkBoxSelenium.click();
        driverFireFox.close();
    }

    private static void shortTask6() {
        WebDriver driverFireFox = new FirefoxDriver();
        driverFireFox.get("http://toolsqa.wpengine.com/automation-practice-form/");
        WebElement dropDownContinents = driverFireFox.findElement(By.id("continents"));
        Select select = new Select(dropDownContinents);
        select.selectByIndex(1);
        select.selectByVisibleText("Africa");
        for (WebElement str : select.getOptions()) {
            System.out.println(str.getText());
        }
        select.selectByIndex(3);
        driverFireFox.close();
    }
}
