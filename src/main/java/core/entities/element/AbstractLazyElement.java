package core.entities.element;

import core.WaitFor;
import core.conditions.Condition;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.actions;
import static core.ConciseAPI.byCss;
import static core.ConciseAPI.getWebDriver;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;


public abstract class AbstractLazyElement implements LazyElement {

    @Override
    public abstract WebElement getWrappedEntity();

    @Override
    public LazyElement shouldBe(Condition<WebElement>... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    @Override
    public LazyElement should(Condition<WebElement>... conditions) {
        return shouldBe(conditions);
    }

    @Override
    public LazyElement shouldHave(Condition<WebElement>... conditions) {
        return shouldBe(conditions);
    }

    @Override
    public boolean is(Condition<WebElement> condition) {
        return condition.apply(this) != null;
    }

    @Override
    public boolean has(Condition<WebElement> condition) {
        return is(condition);
    }

    public LazyElement doubleClick() {
        WebElement element = WaitFor.until(this, visible());
        actions().doubleClick(element).perform();
        return this;
    }

    public LazyElement hover() {
        WebElement element = WaitFor.until(this, visible());
        actions().moveToElement(element).perform();
        return this;
    }

    public LazyElement pressEnter() {
        WaitFor.until(this, visible());
        sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        WaitFor.until(this, visible());
        sendKeys(Keys.ESCAPE);
        return this;
    }

    @Override
    public LazyElement setValue(String text) {
        WebElement element = WaitFor.until(this, visible());
        element.clear();
        sendKeys(text);
        return this;
    }

    @Override
    public void click() {
        WebElement element = WaitFor.until(this, visible());
        element.click();
    }

    @Override
    public LazyElement $(By innerLocator) {
        WebElement element = getWrappedEntity().findElement(innerLocator);
        return new LazyWrappedWebElement(element);
    }

    @Override
    public LazyElement find(By innerLocator) {
        return $(innerLocator);
    }

    @Override
    public LazyElement $(String innerCssSelector) {
        return $(byCss(innerCssSelector));
    }

    @Override
    public LazyElement find(String innerCssSelector) {
        return $(byCss(innerCssSelector));
    }

    @Override
    public void submit() {
        getWrappedEntity().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        getWrappedEntity().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        getWrappedEntity().clear();
    }

    @Override
    public String getTagName() {
        WaitFor.until(this, present());
        return getWrappedEntity().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        WaitFor.until(this, present());
        return getWrappedEntity().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return getWrappedEntity().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getWrappedEntity().isEnabled();
    }

    @Override
    public String getText() {
        return getWrappedEntity().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        WaitFor.until(this, present());
        return getWebDriver().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        WaitFor.until(this, present());
        return getWebDriver().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return getWrappedEntity().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return getWrappedEntity().getLocation();
    }

    @Override
    public Dimension getSize() {
        return getWrappedEntity().getSize();
    }

    @Override
    public Rectangle getRect() {
        return getWrappedEntity().getRect();
    }

    @Override
    public String getCssValue(String s) {
        WaitFor.until(this, present());
        return getWrappedEntity().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getWrappedEntity().getScreenshotAs(outputType);
    }
}
