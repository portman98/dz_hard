package test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;


/**
 * Unit test for simple App.
 */
public class AppTest {
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");

        //Configuration.browser = "chrome";
        //Configuration.startMaximized = true;
        // Configuration.timeout = 3000;

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

    }

    @After
    public void after(){
        System.out.println("ТЕСТ завершен");

    }
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        open("https://dev.n7lanit.ru/");
        $(By.xpath("//button[@class = 'btn navbar-btn btn-default btn-sign-in']")).click();
        $(By.xpath("//div[@class='control-input']/input[@id='id_username']")).val("portman");
        $(By.xpath("//div[@class='control-input']/input[@id='id_password']")).val("aznikol98");
        Thread.sleep(1000);
        $(By.xpath("//button[@class = 'btn btn-primary btn-block']")).click();
        Thread.sleep(1000);
        if($(By.xpath("//img[@class = 'user-avatar']")).isDisplayed()){
            System.out.println("Ок");
            $(By.xpath("//button/span[contains(text(), 'Категория')]/..")).should(Condition.visible).click();
            $(By.xpath("//a[@class = 'btn btn-link']")).should(Condition.visible).click();
            ElementsCollection collection = $$(By.xpath("//div[./div/div/span[1][@class='thread-detail-replies']]/a"));
            collection.get((int) (collection.size()*Math.random())).click();
            Thread.sleep(1000);
            $(By.xpath("//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).click();
            Thread.sleep(1000);
            $(By.xpath("//div/textarea[@id='editor-textarea']")).setValue("Пьеса 'Как сложно быть серьезным' была \" +\n" +
                    "                \"написана летом 1894 года, а опубликована в 1899 году с посвящением английскому литературному \" +\n" +
                    "                \"критику Роберту Россу (1869-1918) - другу, а впоследствии и литературному душеприказчику Уайльда.");
            Thread.sleep(1000);
            $(By.xpath("//div[@class = 'editor-footer']/button[@class = 'btn btn-primary btn-sm pull-right']")).should(Condition.visible).click();
            Thread.sleep(1000);

            $(By.xpath("//button/span[contains(text(), 'Категория')]/..")).should(Condition.visible).click();
            $(By.xpath("//a[@class = 'btn btn-link']")).should(Condition.visible).click();

            ElementsCollection collection2 = $$(By.xpath("//div[./div/div/span[1][@class='thread-detail-replies']]/a"));
            collection2.get((int) (collection2.size()*Math.random())).click();

            Thread.sleep(1000);

            $(By.xpath("//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).click();
            Thread.sleep(1000);

            $(By.xpath("//div/textarea[@id='editor-textarea']")).setValue("Правила Киргофа — соотношения, которые выполняются между токами и напряжениями на участках любой электрической цепи.\\n\" +\n" +
                    "                \"Решения систем линейных уравнений, составленных на основе правил Кирхгофа, позволяют найти все токи и напряжения в электрических цепях постоянного, переменного и квазистационарного тока.\\n\" +\n" +
                    "                \"Имеют особое значение в электротехнике из-за своей универсальности, так как пригодны для решения многих задач в теории электрических цепей и практических расчётов сложных электрических цепей.\\n\" +\n" +
                    "                \"Применение правил Кирхгофа к линейной электрической цепи позволяет пол");
            Thread.sleep(1000);
            $(By.xpath("//div[@class = 'editor-footer']/button[@class = 'btn btn-primary btn-sm pull-right']")).should(Condition.visible).click();
        }

        else {
            System.out.println("Не авторизован");
        }




    }


}