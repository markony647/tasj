package core.conditions.element;


public class Text extends ExactText {

    public Text(String expectedText) {
        super(expectedText);
    }

    public boolean checkElement() {
        return actualText.contains(expectedText);
    }
}
