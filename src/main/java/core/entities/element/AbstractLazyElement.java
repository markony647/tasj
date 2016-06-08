package core.entities.element;

import core.WaitFor;
import core.conditions.Condition;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.actions;
import static core.ConciseAPI.byCss;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;


public abstract class AbstractLazyElement implements LazyElement {

    @Override
    public abstract WebElement getWrappedEntity();

    @Override
    public LazyElement find(By innerLocator) {
        return new LazyElementInnerElement(innerLocator, this);
    }

    @Override
    public LazyElement find(String innerCssSelector) {
        return find(byCss(innerCssSelector));
    }

    @Override
    public LazyElement $(By innerLocator) {
        return find(innerLocator);
    }

    @Override
    public LazyElement $(String innerCssSelector) {
        return find(innerCssSelector);
    }

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
        WebElement element = WaitFor.until(this, visible());
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        WebElement element = WaitFor.until(this, visible());
        element.sendKeys(Keys.ESCAPE);
        return this;
    }

    @Override
    public LazyElement setValue(String text) {
        WebElement element = WaitFor.until(this, visible());
        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Override
    public void click() {
        WebElement element = WaitFor.until(this, visible());
        element.click();
    }

    @Override
    public void submit() {
        WebElement element = WaitFor.until(this, visible());
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        WebElement element = WaitFor.until(this, visible());
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        WaitFor.until(this, visible());
        getWrappedEntity().clear();
    }

    @Override
    public String getTagName() {
        WaitFor.until(this, present());
        return getWrappedEntity().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        WebElement element = WaitFor.until(this, present());
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        WebElement element = WaitFor.until(this, present());
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getWrappedEntity().isEnabled();
    }

    @Override
    public String getText() {
        WebElement element = WaitFor.until(this, present());
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        WebElement element = WaitFor.until(this, present());
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        WebElement element = WaitFor.until(this, present());
        return element.findElement(by);
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
