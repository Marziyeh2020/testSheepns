import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Test extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement firstnumberinput= driver.findElement(By.id("number1Field"));
        WebElement secondnumberinput= driver.findElement(By.id("number2Field"));

        Select calculate=new Select(driver.findElement(By.id("selectOperationDropdown")));

        WebElement calculatebutton=driver.findElement(By.id("calculateButton"));
        WebElement answer=driver.findElement(By.id("numberAnswerField"));
        WebElement integerselect=driver.findElement(By.id("integerSelect"));
        WebElement clear=driver.findElement(By.id("clearButton"));


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
               calculate.selectByIndex(i);

               int firstnumber=(int)(Math.random()*100);
               int secondnumber=(int)(Math.random()*100);


               String actualnumber=returntotal(i,firstnumber,secondnumber);

               firstnumberinput.sendKeys(String.valueOf(firstnumber));
               secondnumberinput.sendKeys(String.valueOf(secondnumber));
               calculatebutton.click();

               wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberAnswerField")));

                System.out.println("actualnumber = " + actualnumber);
                System.out.println("answer = " + answer.getAttribute("value"));

                Assert.assertEquals(actualnumber,answer.getAttribute("value"));

                firstnumberinput.clear();
                secondnumberinput.clear();

            }

        }

    BekleKapat();

    }


    public static String returntotal(int type,int number1,int number2){
        String total="";

        if (type==0){
            total=String.valueOf(number1+number2);
        } else if (type==1) {
            total=String.valueOf(number1-number2);
        } else if (type==2) {
            total=String.valueOf(number1*number2);
        } else if (type==3) {
            total=String.valueOf(number1/number2);
        } else if (type==4) {
            total=String.valueOf(number1)+number2;
        }


        return total;
    }
}
