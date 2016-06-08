package pages;

import core.entities.collection.LazyCollection;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.texts;
import static core.conditions.ElementConditions.exactText;


public class Mail {

    public static LazyCollection mails = $$("[gh='tl'] .zA");

    public static void send(String recipient, String subjectText) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(recipient).pressEnter();
        $(By.name("subjectbox")).setValue(subjectText).pressEnter();
        $(byText("Send")).click();
    }

    public static void searchBySubject(String subjectText) {
        $(By.name("q")).setValue("subject: " + subjectText).pressEnter();
    }

    public static void assertMails(String... mailsTexts) {
        mails.shouldHave(texts(mailsTexts));
    }

    public static void assertMail(int index, String subjectText) {
       // mails.get(index).$(".y6").shouldHave(exactText(subjectText));
    }
}