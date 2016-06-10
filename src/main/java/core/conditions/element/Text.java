package core.conditions.element;


public class Text extends ExactText {

    public Text(String expectedText) {
        super(expectedText);
    }

    @Override
    public boolean checkElement() {
        return actualText.contains(expectedText);
    }
}
