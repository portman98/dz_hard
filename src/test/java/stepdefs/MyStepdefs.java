package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.AbstractPage.getPageByTitle;
import static pages.AbstractPage.getUrlByTitle;




public class MyStepdefs {

    @И("Начинаем тест")
    public void начинаемТест() {
        System.out.println("Начинаем тест");
    }
    @И("открываем страницу {string}")
    public void открываемСайт(String site) throws ClassNotFoundException {
        open(getUrlByTitle(site));
    }
    @И("на странице {string} нажимаем кнопку {string}")
    public void нажимаемКнопкуАвторизации(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName).click();
    }
    @И("вводим логин {string}")
    public void вводимЛогин(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName);
    }
    @И("вводим пароль {string}")
    public void вводимПароль(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName);
    }
    @И("авторизуемся {string}")
    public void авторизация(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName).click();
    }
    @И("проверяем авторизацию {string}")
    public void проверкаАвторизации(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {

        if(getPageByTitle(title).getElementByName(tabName).isDisplayed()){
            System.out.println("Аавторизирован");
        }
        else{
            System.out.println("Не-а, снова авторизируйся");
            WebDriverRunner.closeWebDriver();
        }
    }
    @И("выбираем случайную тему {string}")
    public void выбираемСлучайнуюТему(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName).click();
    }
    @И("нажимаем кнопку Ответить {string}")
    public void нажимаемКнопкуОтветить(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName).click();
    }
    @И("вводим сообщение {string}")
    public void вводСообщения(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName);
    }
    @И("отправляем сообщение {string}")
    public void отправлениеСообщения(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName).click();
    }
    @И("переход на вкладку Темы {string}")
    public void переходВкладкаТемы(String title, String tabName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        getPageByTitle(title).getElementByName(tabName).click();
    }

    @И("проверяем отправку сообщения")
    public void проверяемОтправкуСообщения() {
        $(By.xpath("(//ul[@class='posts-list ui-ready']/li[@class='post'])[last()]")).shouldBe(Condition.visible);
    }
}