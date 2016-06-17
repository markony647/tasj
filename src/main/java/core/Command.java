package core;


import org.openqa.selenium.WebElement;


public interface Command<T> {

    T execute(WebElement element);
}
