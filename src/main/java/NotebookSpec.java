import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NotebookSpec {
    public static void main(String[] args) {

//        Yoy must change the path to the chromeDriver to be your own computer path e.g. <PATH>\\chromedriver.exe>
        System.setProperty("webdriver.chrome.driver", "E:\\Work MU\\Y4\\S1\\Software Test\\Selenium\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://notebookspec.com/web/";
        String actualTitle = "";

        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();

//        System.out.println("ข้ามแล้ว");

        // Check the title of the page
//        System.out.println(driver.getCurrentUrl());

//        TEST CASE 1
        final String aboutusURL = "https://notebookspec.com/contact.html";
        testCase01(driver, aboutusURL);

//        TEST CASE 2
        final String topChartURL = "https://notebookspec.com/topchart/notebook.html";
        testCase02(driver, topChartURL);

//        TEST CASE 3
        final String techNewsURL = "https://notebookspec.com/web/category/tech-news";
        testCase03(driver, techNewsURL);

//        TEST CASE 4
        final String specPC = "https://notebookspec.com/pc/spec";
        testCase04(driver, specPC);

//        TEST CASE 5
        testCase05(driver);

//        TEST CASE 6
        testCase06(driver);

//        TEST CASE 7
        final String query = "Asus";
        testCase07(driver, query);

//        TEST CASE 8
        final String sortURL = "https://notebookspec.com/notebook/search?";
        testCase08(driver, sortURL);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        TEST CASE 9
        testCase09(driver);

//        TEST CASE 10
        testCase10(driver);

        driver.quit();
    }

    public static void testCase01(WebDriver driver, final String aboutusURL) {
        System.out.println("Test Case 1:");
        driver.findElement(By.linkText("ติดต่อเรา")).click();

        if (driver.getCurrentUrl().equals(aboutusURL)) {
            System.out.println("Test Success!");
        } else {
            System.out.println("Test Failed!");
        }

        driver.navigate().to("https://notebookspec.com/web/");
    }

    public static void testCase02(WebDriver driver, final String topChartURL) {
        System.out.println("Test Case 2:");
        driver.findElement(By.linkText("ดูรุ่นทั้งหมด")).click();

        if (driver.getCurrentUrl().equals(topChartURL)) {
            System.out.println("Test Success!");
        } else {
            System.out.println("Test Failed!");
        }

        driver.navigate().to("https://notebookspec.com/web/");
    }

    public static void testCase03(WebDriver driver, final String techNewsURL) {
        System.out.println("Test Case 3:");
        driver.findElement(By.linkText("บทความยอดนิยม")).click();

        if (driver.getCurrentUrl().equals(techNewsURL)) {
            System.out.println("Test Success!");
        } else {
            System.out.println("Test Failed!");
        }
        driver.navigate().to("https://notebookspec.com/web/");
    }

    public static void testCase04(WebDriver driver, final String specPC) {
        System.out.println("Test Case 4:");
        driver.findElement(By.linkText(("จัดสเปค"))).click();

        if (driver.getCurrentUrl().equals(specPC)) {
            System.out.println("Test Success!");
        } else {
            System.out.println("Test Failed!");
        }
        driver.navigate().to("https://notebookspec.com/web/");
    }

    public static void testCase05(WebDriver driver) {
        System.out.println("Test Case 5:");
        driver.navigate().to("https://notebookspec.com/notebook/search?");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("ค้นหาโน๊ตบุ๊คเล่มเกมส์")).click();

        if (driver.findElement(By.id("filter-price")).isDisplayed()) {
            System.out.println("Test Success!");
        } else if (driver.findElement(By.id("filter-type")).isDisplayed()) {
            System.out.println("Test Failed!");
        }
    }

    public static void testCase06(WebDriver driver) {
        System.out.println("Test Case 6:");
        driver.navigate().to("https://notebookspec.com/notebook/search?");

        driver.findElement(By.xpath("" +
                "/html/body/section/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]"
        )).click();
        driver.findElement(By.linkText("ค้นหาโน๊ตบุ๊คเล่มเกมส์")).click();

//        Delay load time
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("" +
                "/html/body/section/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[1]")).click();

        if (driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[2]")).isDisplayed()
                && driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[2]")).isDisplayed()) {
            System.out.println("Test Failed!");
        } else {
            System.out.println("Test Success!");
        }
    }

    public static void testCase07(WebDriver driver, final String query) {
        System.out.println("Test Case 7:");
        driver.navigate().to("https://notebookspec.com/notebook/search?");
        WebElement element = driver.findElement(By.className("search-input-box")).findElement(By.tagName("input"));
        element.sendKeys(query);

//      Delay the loading time of query result, since it is too fast
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test search
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                int count = 0;
                List<WebElement> result = (List<WebElement>) d.findElements(By.className("search-result-item"));
                String upQuery = query.toUpperCase();
//                System.out.println(result.size());
//                System.out.println(result.get(0).findElement(By.className("item-info")).findElement(By.className("title")).getText());

                for (int i = 0; i < result.size(); i++) {
                    String productName = result.get(i).findElement(By.className("item-info")).findElement(By.className("title")).getText().toUpperCase();
//                    System.out.println(i + ": " + productName + " " + upQuery);
                    if (!productName.contains(upQuery)) {
                        count++;
                    }
//                    System.out.println("Count = " + count);
                }
                if (count > 0) {
                    System.out.println("Test Failed!");
                } else {
                    System.out.println("Test Success!");
                }

                return count == 0;
            }
        });
    }

    public static void testCase08(WebDriver driver, final String specPC) {
        System.out.println("Test Case 8:");
        driver.navigate().to("https://notebookspec.com/notebook/search?");
        WebElement option = driver.findElement(By.className("dropdown")).findElement(By.id("display-option"));
        option.click();
        WebElement cheapest = driver.findElement(By.linkText("ราคาต่ำสุด"));
        cheapest.click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Gooooooooooooooo");
        // Test sort
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                int count = 0;
                int Price[] = new int[50];
                String PriceSTR[] = new String[50];
                List<WebElement> result = (List<WebElement>) d.findElements(By.className("search-result-item"));

                for (int i = 0; i < result.size(); i++) {
                    PriceSTR[i] = result.get(i).findElement(By.className("price")).findElement(By.tagName("span")).getText();
                    PriceSTR[i] = PriceSTR[i].replaceAll("[^a-zA-Z0-9]", "");
                    Price[i] = Integer.parseInt(PriceSTR[i]);
//                    System.out.println("At " + i + ", Price: " + Price[i]);
                }
//                System.out.println("Size: " + result.size());
                for (int j = 0; j < result.size() - 1; j++) {
                    if (Price[j] > Price[j + 1]) {
                        count++;
                    }
                }
                if (count > 0) {
                    System.out.println("Test Failed!");
                } else {
                    System.out.println("Test Success!");
                }

                return count == 0;
            }
        });
    }

    public static void testCase09(WebDriver driver) {
        System.out.println("Test Case 9:");
        driver.navigate().to("https://notebookspec.com/notebook/search?");

        int count = 0;
        List<WebElement> result = (List<WebElement>) driver.findElements(By.className("search-result-item"));

//        Click compared of the first two result-items
        for (int i = 0; i < 2; i++) {
            result.get(i).findElement(By.tagName("a")).click();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("compare-submmit")).click();
//        driver.navigate().to("https://notebookspec.com/compare/notebook?models=10574,10575");

//        Switch tab to new tab
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

//        Delay for a few seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("highlight-not-same")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> difSpecRow = new ArrayList<String> ();

//        final String color1 = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[2]/div/div[2]/section[2]/div[2]")).getCssValue("background-color");
//        final String color2 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[5]/div[2]")).getCssValue("background-color");
//        final String color3 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[6]/div[4]")).getCssValue("background-color");
//        final String color4 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[6]/div[8]")).getCssValue("background-color");
//        final String color5 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[7]/div[3]")).getCssValue("background-color");
//        final String color6 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[7]/div[6]")).getCssValue("background-color");
//        final String color7 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[7]/div[7]")).getCssValue("background-color");
//        final String color8 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[7]/div[8]")).getCssValue("background-color");
//        final String color9 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[7]/div[9]")).getCssValue("background-color");
//        final String color10 = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/section[7]/div[13]")).getCssValue("background-color");

        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[2]/div[2]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[5]/div[2]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[6]/div[4]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[6]/div[8]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[7]/div[3]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[7]/div[6]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[7]/div[7]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[7]/div[8]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[7]/div[9]")).getCssValue("background-color"));
        difSpecRow.add(driver.findElement(By.xpath("//*[@id=\"compare-table\"]/section[7]/div[13]")).getCssValue("background-color"));

//        System.out.println(color1);
        int cnt = 0;
        for(String i: difSpecRow) {
            if(!i.equals("rgba(241, 241, 241, 1)")){
                cnt++;
            }
        }

        if(cnt == 0) {
            System.out.println("Test Success!");
        } else {
            System.out.println("Test Failed!");
        }

//        if (color1.equals("rgba(241, 241, 241, 1)")) {
//            System.out.println("Test Success!");
//        } else {
//            System.out.println("Test Failed!");
//        }
    }

    public static void testCase10(WebDriver driver) {
        System.out.println("Test Case 10:");
        driver.navigate().to("https://notebookspec.com/notebook/search?");

        String a = driver.findElement(By.xpath("//*[@id=\"header-new-section\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).getAttribute("innerHTML");
        String b = driver.findElement(By.xpath("//*[@id=\"header-new-section\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")).getAttribute("innerHTML");
        String c = driver.findElement(By.xpath("//*[@id=\"header-new-section\"]/ul/li[1]/ul/li[1]/ul/li[3]/a")).getAttribute("innerHTML");
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        if(a.equals("โน๊ตบุ๊คเกมมิ่ง") && b.equals("โน๊ตบุ๊คใช้งานทั่วไป") && c.equals("โน๊ตบุ๊คบางเบา")) {
            System.out.println("Test Success!");
        } else {
            System.out.println("Test Failed!");
        }
    }

}
