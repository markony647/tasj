package com.google.mail.core.base;

import com.google.mail.core.WaitFor;
import com.google.mail.core.conditions.Condition;
import org.openqa.selenium.*;

import java.util.List;

import static com.google.mail.core.ConciseAPI.actions;
import static com.google.mail.core.ConciseAPI.getWebDriver;
import static com.google.mail.core.conditions.ElementConditions.visible;


public class Element implements LazyElement {

    private By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    @Override
    public LazyElement shouldBe(Condition<WebElement>... condition) {
        WaitFor.until(this, condition);
        return this;
    }

    @Override
    public WebElement getWrappedEntity() {
        return getWebDriver().findElement(locator);
    }

    public void doubleClick() {
        actions().doubleClick(getVisibleElement()).perform();
    }

    public LazyElement hover() {
        actions().moveToElement(getVisibleElement()).perform();
        return this;
    }

    public void pressEnter() {
        getVisibleElement().sendKeys(Keys.ENTER);
    }

    public void pressEscape() {
        getVisibleElement().sendKeys(Keys.ESCAPE);
    }

    @Override
    public LazyElement setValue(String text) {
        WebElement element = getVisibleElement();
        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Override
    public void click() {
        getVisibleElement().click();
    }

    @Override
    public void submit() {
        getVisibleElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        getVisibleElement().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        getVisibleElement().clear();
    }

    @Override
    public String getTagName() {
        return getVisibleElement().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return getVisibleElement().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return getVisibleElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getVisibleElement().isEnabled();
    }

    @Override
    public String getText() {
        return getVisibleElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getWebDriver().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getWebDriver().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return getVisibleElement().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return getVisibleElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return getVisibleElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return getVisibleElement().getRect();
    }

    @Override
    public String getCssValue(String s) {
        return getVisibleElement().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getVisibleElement().getScreenshotAs(outputType);
    }

    private WebElement getVisibleElement() {
        return WaitFor.until(this, visible());
    }
}
