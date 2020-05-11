package pages;

import org.openqa.selenium.WebElement;
import pages.annotations.Element;
import pages.annotations.Page;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public abstract class AbstractPage {
    static final LinkedList<Class<? extends AbstractPage>>CLASSES = new LinkedList<>();
    static {
        CLASSES.add(MainPage.class);
    }
    public static String getUrlByTitle(String title) throws ClassNotFoundException {
        for(Class<? extends AbstractPage> clazz : CLASSES){
            if(clazz.isAnnotationPresent(Page.class)){
                if(clazz.getAnnotation(Page.class).title().equals(title)){
                    return clazz.getAnnotation(Page.class).url();
                }
            }
        }
        throw new ClassNotFoundException("окно с заголовком " + title + " не найдено в списке");
    }

    public static AbstractPage getPageByTitle(String title) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        for(Class<? extends AbstractPage> clazz : CLASSES){
            if(clazz.isAnnotationPresent(Page.class)){
                if(clazz.getAnnotation(Page.class).title().equals(title)){
                    return clazz.newInstance();
                }
            }
        }
        throw new ClassNotFoundException("окно с заголовком " + title + " не найдено в списке");
    }

    public WebElement getElementByName(String name ) throws InvocationTargetException, IllegalAccessException {
        for(Method method : this.getClass().getMethods()){
            Element element = method.getAnnotation(Element.class);
            if(element != null && element.name().equals(name)){
                return (WebElement) method.invoke(this);
            }
        }
        throw new RuntimeException();
    }

}
