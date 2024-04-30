package demo;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */


import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
    WebDriver driver;

    @BeforeSuite(alwaysRun=true)
    public void launchbrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    public void testcase01() throws InterruptedException{
        double starRating=4.0;
        driver.get("https://www.flipkart.com/");
        Thread.sleep(10000);
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        Boolean flow1Result=Home.search(driver, By.xpath("//input[@title='Search for Products, Brands and More']"),"Washing Machine");
        if(flow1Result){
            System.out.println("flow1 success");
        }else
        System.out.println("Failure flow1");
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        String sorting="Popularity";

        Boolean flow2Result=Home.clickbutton(driver, By.xpath("//div[text()='"+sorting+"']"));
        if(flow2Result){
            System.out.println("Click action success");
        }
        else
        System.out.println("Click Failed");
        Thread.sleep(5000);
        //Print count of items rating less than 4
        ArrayList<String> flow3Result=Home.RatingandTitle(driver, By.xpath("//div[@class='gUuXy-']/span/preceding-sibling::span"), By.xpath("//div[@class='_4rR01T']"), starRating);
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        for(String res : flow3Result){
            System.out.println(res);
        }
        System.out.println("End of testcase01");
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
    }
    @Test
    public void testcase02() throws InterruptedException{
        System.out.println("start of testcase 02");
        double discount=10.0;
        driver.get("https://www.flipkart.com/");
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        Boolean flow1Result=Home.search(driver, By.xpath("//input[@title='Search for Products, Brands and More']"),"iPhone");
        if(flow1Result){
            System.out.println("tc2 Flow1 is sucess");
        }
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        ArrayList<String> flow2Result=Home.RatingandTitle(driver, By.xpath("//div[@class='col col-5-12 nlI3QM']/div/div/div[3]/span"), By.xpath("//div[@class='_4rR01T']"), discount);
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        for(String res : flow2Result){
            System.out.println(res);
        }
        System.out.println("End of testcase02");
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
    }

    @Test(description="Search “Coffee Mug”, select 4 stars and above, and print the Title and image URL of the 5 items with highest number of reviews")
    public void testcase03() throws InterruptedException{
        System.out.println("Start of testcae03");
        driver.get("https://www.flipkart.com/");
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        Boolean flow1Result=Home.search(driver, By.xpath("//input[@title='Search for Products, Brands and More']"),"Coffee Mug");
        if(flow1Result){
            System.out.println("tc2 Flow1 is sucess");
        }
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        Boolean flow2Result=Home.clickbutton(driver, By.xpath("//div[@class='_3879cV' and contains(text(),'4')]"));
        if(flow2Result){
            System.out.println("Click action success");
        }
        else
        System.out.println("Click Failed");
        Thread.sleep(5000);
        String sorting="Popularity";

        Boolean flow3Result=Home.clickbutton(driver, By.xpath("//div[text()='"+sorting+"']"));
        if(flow3Result){
            System.out.println("Click action success");
        }
        else
        System.out.println("Click Failed");
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        Thread.sleep(5000);
        ArrayList<String> flow4Result=Home.titleandimgreview(driver, By.xpath("//div[@class='gUuXy- _2D5lwg']/span/div[text()>='4']/../../preceding-sibling::a[@class='s1Q9rs']"), By.xpath("//div[@class='CXW8mj']/img"), By.xpath("//div[@class='gUuXy- _2D5lwg']/span/div[text()>='4']/../following-sibling::span"));
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
        for(String res : flow4Result){
            System.out.println(res);
        }
        System.out.println("End of testcase02");
        Thread.sleep((new java.util.Random().nextInt(3)+2)*3);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}