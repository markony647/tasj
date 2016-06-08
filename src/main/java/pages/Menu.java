package pages;


import static core.ConciseAPI.$;
import static core.ConciseAPI.byText;

public class Menu {

    public static void goToInbox() {
        $("a[title~='Inbox']").click();
    }

    public static void goToSent() {
        $(byText("Sent Mail")).click();
    }

    public static void refresh() {
        $("[title='Refresh']").click();
    }
}
