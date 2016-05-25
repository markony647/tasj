package com.google.mail.core.conditions.conditions;


public class Texts extends ExactTexts {


    public Texts(String... texts) {
        super(texts);
    }

    @Override
    public boolean checkElement(int index) {
        if (!actualTexts.get(index).contains(expectedTexts[index])) {
            return false;
        }
        return true;
    }
}
