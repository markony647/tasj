package com.google.mail.core.conditions;


import org.openqa.selenium.WebElement;

import java.util.List;

public class PresentElements extends CollectionCondition {

    @Override
    public List<WebElement> check(List<WebElement> entity) {

        for (WebElement element : entity) {
            if (entity.size() > 0) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public String getExpectedResult() {
        return " are presenceOfElements";
    }

    @Override
    public String getActualResult() {
        return " are not presenceOfElements";
    }


}
