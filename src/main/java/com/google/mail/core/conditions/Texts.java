package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.google.mail.core.Helpers.getTexts;


public class Texts extends ExactTexts {


    public Texts(String... expectedTexts) {
        super(expectedTexts);
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {

        actualTexts = new ArrayList<String>();
        this.elements = elements;

        actualTexts = getTexts(elements);

        if (actualTexts.size() != expectedTexts.length) {
            return null;
        }

        for (int i = 0; i < expectedTexts.length; i++) {
            if (!(actualTexts.get(i).contains(expectedTexts[i]))) {
                return null;
            }
        }
        return elements;
    }
}
