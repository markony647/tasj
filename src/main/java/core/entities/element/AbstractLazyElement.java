package core.entities.element;

import core.WaitFor;
import core.WithWaitFor;
import core.conditions.Condition;
import core.entities.LazyCollection;
import core.entities.LazyElement;
import core.entities.collection.LazyElementInnerCollection;
import core.Command;
import core.exceptions.ElementNotFoundException;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.actions;
import static core.ConciseAPI.byCss;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;


public abstract class AbstractLazyElement implements LazyElement {

    public abstract WebElement fetchWrappedEntity();

    @Override
    public WebElement getWrappedEntity() {
        WebElement actualElement = fetchWrappedEntity();
        if (actualElement == null) {
            throw new ElementNotFoundException(toString());
        }
        return actualElement;
    }

    @Override
    public LazyElement find(By innerLocator) {
        return new LazyElementInnerElement(this, innerLocator);
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
    public LazyCollection findAll(By innerLocator) {
        return new LazyElementInnerCollection(this, innerLocator);
    }

    @Override
    public LazyCollection findAll(String cssInnerLocator) {
        return findAll(byCss(cssInnerLocator));
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
        try {
            return condition.check(getWrappedEntity());
        } catch (WebDriverException e) {
            return false;
        }
    }

    @Override
    public boolean has(Condition<WebElement> condition) {
        return is(condition);
    }

    @Override
    public LazyElement pressTab() {
        sendKeys(Keys.TAB);
        return this;
    }

    @Override
    public LazyElement doubleClick() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                actions().doubleClick(element).perform();
                return element;
            }
        });
        return this;
    }

    @Override
    public LazyElement hover() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                actions().moveToElement(element).perform();
                return element;
            }
        });
        return this;
    }

    @Override
    public LazyElement pressEnter() {
        sendKeys(Keys.ENTER);
        return this;
    }

    @Override
    public LazyElement pressEscape() {
        sendKeys(Keys.ESCAPE);
        return this;
    }

    @Override
    public LazyElement setValue(final String text) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.clear();
                element.sendKeys(text);
                return element;
            }
        });
        return this;
    }

    @Override
    public void click() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.click();
                return element;
            }
        });
    }

    @Override
    public void submit() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.submit();
                return element;
            }
        });
    }

    @Override
    public void sendKeys(final CharSequence... charSequences) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.sendKeys(charSequences);
                return element;
            }
        });
    }

    @Override
    public void clear() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.clear();
                return element;
            }
        });
    }

    @Override
    public String getTagName() {
        return new WithWaitFor(this, visible()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return element.getTagName();
            }
        });
    }

    @Override
    public String getAttribute(final String s) {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return element.getAttribute(s);
            }
        });
    }

    @Override
    public boolean isSelected() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            @Override
            public Boolean execute(WebElement element) {
                return element.isSelected();
            }
        });
    }

    @Override
    public boolean isEnabled() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            @Override
            public Boolean execute(WebElement element) {
                return element.isEnabled();
            }
        });
    }

    @Override
    public String getText() {
        return new WithWaitFor(this, visible()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return element.getText();
            }
        });
    }

    @Override
    public List<WebElement> findElements(final By by) {
        return new WithWaitFor(this, visible()).run(new Command<List<WebElement>>() {
            @Override
            public List<WebElement> execute(WebElement element) {
                return element.findElements(by);
            }
        });
    }

    @Override
    public WebElement findElement(final By by) {
        return new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                return element.findElement(by);
            }
        });
    }

    @Override
    public boolean isDisplayed() {
        return new WithWaitFor(this, present()).run(new Command<Boolean>() {
            @Override
            public Boolean execute(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    @Override
    public Point getLocation() {
        return new WithWaitFor(this, visible()).run(new Command<Point>() {
            @Override
            public Point execute(WebElement element) {
                return element.getLocation();
            }
        });
    }

    @Override
    public Dimension getSize() {
        return new WithWaitFor(this, visible()).run(new Command<Dimension>() {
            @Override
            public Dimension execute(WebElement element) {
                return element.getSize();
            }
        });
    }

    @Override
    public Rectangle getRect() {
        return new WithWaitFor(this, visible()).run(new Command<Rectangle>() {
            @Override
            public Rectangle execute(WebElement element) {
                return element.getRect();
            }
        });
    }

    @Override
    public String getCssValue(final String s) {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return element.getCssValue(s);
            }
        });
    }

    @Override
    public <X> X getScreenshotAs(final OutputType<X> outputType) throws WebDriverException {
        return new WithWaitFor(this, visible()).run(new Command<X>() {
            @Override
            public X execute(WebElement element) {
                return element.getScreenshotAs(outputType);
            }
        });
    }
}
