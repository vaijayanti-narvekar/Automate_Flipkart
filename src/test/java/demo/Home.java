package demo;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    public Home(WebDriver driver){
        this.driver=driver;
    }

    public static boolean search(WebDriver driver,By locator,String text){
        boolean success;
        try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement textfield=driver.findElement(locator);
        textfield.clear();
        textfield.sendKeys(text);
        textfield.sendKeys(Keys.ENTER);
        success=true;
        }catch(Exception e){
            System.out.println("Exception Occured"+e.getMessage());
            success=false;
        }
        return success;

    }
    public static boolean clickbutton(WebDriver driver,By locator){
        boolean success;
        System.out.println("Clicking action");
        try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement Button=driver.findElement(locator);
        Button.isEnabled();
        Button.click();
        success =true;
        }catch(Exception e){
            System.out.println("Exception occured"+e.getMessage());
            success=false;
        }
        return success;
    }
    public static ArrayList<String> RatingandTitle(WebDriver driver,By locatorofrating,By locatorofTitle,double starrating){
        System.out.println("Print title of product for rating <=4");
        List<WebElement> titles=driver.findElements(locatorofTitle);
        List<WebElement> ratings=driver.findElements(locatorofrating);
        System.out.println("Tiles count" + titles.size() + " ratings count "+ratings.size());
        ArrayList<String> result=new ArrayList<>();
        if(titles.size()!=ratings.size()){
            System.out.println("Mismatch in the count");
            if(ratings.size()>titles.size()) ratings=sliceArrayList(ratings, titles.size());
            else titles=sliceArrayList(titles, ratings.size());
        }

        for(int i=0;i<titles.size();i++){
            String title=titles.get(i).getText();
            String rating=ratings.get(i).getText();
            rating=Removesubstring(rating, "% off");
            float attributeFloat=0; 
            try{
                attributeFloat=Float.parseFloat(rating);
                if(attributeFloat>=starrating)
                result.add(title + " has a attri of "+attributeFloat);
            }catch(NumberFormatException e){
                System.out.println("Invalid Rating format for: "+title +", rating : "+ attributeFloat);

            }
        }
        return result;

    }
    public static String Removesubstring(String Original, String substringtoremove){
        if(Original.contains(substringtoremove)){
            return Original.replace(substringtoremove, "").trim();
        }
        return Original;
    }
    public static <T> List<T> sliceArrayList(List<T> list,int n){
        //ensure size n doesnot exceed list size
        n=Math.min(n,list.size());
        return new ArrayList<>(list.subList(0, n));
    }

    public static ArrayList<String> titleandimgreview(WebDriver driver,By locatorbytitle,By locatorbyimgurl,By locatorbyreview){
        List<WebElement> titles=driver.findElements(locatorbytitle);
        List<WebElement> imgurl=driver.findElements(locatorbyimgurl);
        List<WebElement> reviews=driver.findElements(locatorbyreview);
        System.out.println("title "+titles.size()+" imgurl "+imgurl.size()+" review "+reviews.size() );
        ArrayList<String> result=new ArrayList<>();
        for(int i=0;i<5;i++){
            String title=titles.get(i).getText();
            String url=imgurl.get(i).getAttribute("src");
            String review=reviews.get(i).getText();
            result.add(title + " "+ url+ " "+review);
        }
        return result;
    }

    
}
