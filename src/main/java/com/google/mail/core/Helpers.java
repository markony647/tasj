package com.google.mail.core;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Helpers {

    public static List<String> getTexts(List<WebElement> elements) {
        List<String> listTexts = new ArrayList<String>();

        for (WebElement element : elements) {
            listTexts.add(element.getText());
        }

        return listTexts;
    }

    public static String getString(List<String> texts) {
        for (String text : texts) {
            return text;
        }
        return "";
    }
}
