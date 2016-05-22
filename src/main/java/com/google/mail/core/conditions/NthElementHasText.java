package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;


public class NthElementHasText extends ElementCondition {
    private int index;
    private String expectedText;
    private WebElement element;
    private String actualText;

    public NthElementHasText(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    @Override
    public WebElement check(WebElement e) {
        e = getWebElementByIndex(index);

        this.element = e;
        actualText = e.getText();
        if (actualText.contains(expectedText)) {
            return element;
        }
        return null;
    }


    @Override
    public String getExpectedResult() {
        return expectedText;
    }

    @Override
    public String getActualResult() {
        return actualText;
    }
}


