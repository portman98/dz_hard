package pages;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.annotations.Page;
import pages.annotations.Element;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Page(title = "Главная страница", url = "https://dev.n7lanit.ru")
public class MainPage extends AbstractPage {

    @Element(name = "Войти")
    public WebElement getButtonSign() {
        return  $(By.xpath("//button[@class = 'btn navbar-btn btn-default btn-sign-in']"));
    }
    @Element(name = "Логин")
    public WebElement getLoginField() {
        return  $(By.xpath("//input[@id = 'id_username']"));
    }
    @Element(name = "Пароль")
    public WebElement getPasswordField() {
        return  $(By.xpath("//input[@id = 'id_password']"));
    }
    @Element(name = "Авторизация")
    public WebElement getButtonSign2() {
        return  $(By.xpath("//button[@class = 'btn btn-primary btn-block']"));
    }
    @Element(name = "Ава")
    public WebElement getAvatar() {
        return  $(By.xpath("//img[@class = 'user-avatar']"));
    }
    @Element(name = "Тема")
    public WebElement getRandomTheme() {
        ElementsCollection collection=  $$(By.xpath("//span[@class='thread-detail-replies' and not(preceding-sibling::span)]/ancestor::div[3]/a"));
        return collection.get((int) (collection.size()*Math.random()));
    }
    @Element(name = "Кнопка ответить")
    public WebElement getButtonReply() {
        return  $(By.xpath("//button[@class = 'btn btn-primary btn-block btn-outline']"));
    }
    @Element(name = "Ввод сообщения")
    public WebElement getFieldMessage() {
        return  $(By.xpath("//textarea[@class = 'form-control']"));
    }
    @Element(name = "Кнопка отправить ответ")
    public WebElement getButtonSendMessage() {
        return  $(By.xpath("//div[@class = 'editor-footer']/button[@class = 'btn btn-primary btn-sm pull-right']"));
    }
    @Element(name = "Вкладка Темы")
    public WebElement getThemesTab() {
        return  $(By.xpath("//ul[@class = 'nav navbar-nav']//a[contains(text(), 'Темы')]"));
    }
}