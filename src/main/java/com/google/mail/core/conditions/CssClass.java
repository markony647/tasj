package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.google.mail.core.Helpers.getString;


public class CssClass extends ElementCondition {
    private String cssClass;
    private List<String> actualCssClasses;
    private List<WebElement> elements;

    public CssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public WebElement check(WebElement entity) {
        actualCssClasses = new ArrayList<String>();
        elements = entity.findElements(locator);
        for (WebElement e : elements) {
            actualCssClasses.add(e.getAttribute("class"));
        }

        for (int i = 0; i < actualCssClasses.size(); i++) {
            String[] elementClasses = actualCssClasses.get(i).split(" ");
            for (String elementClass : elementClasses) {
                if (elementClass.equals(cssClass)) {
                    return elements.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public String getExpectedResult() {
        return cssClass;
    }

    @Override
    public String getActualResult() {
        return getString(actualCssClasses);
    }
}
