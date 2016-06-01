package com.google.mail.core.conditions.collection;


public class Texts extends ExactTexts {


    public Texts(String... texts) {
        super(texts);
    }

    @Override
    public boolean checkElement(int index) {
        return actualTexts.get(index).contains(expectedTexts[index]);
    }
}
