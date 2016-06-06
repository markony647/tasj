package core.conditions.collection;


public class Texts extends ExactTexts {

    public Texts(String... expectedTexts) {
        super(expectedTexts);
    }

    @Override
    public boolean checkElement(int index) {
        return actualTexts.get(index).contains(expectedTexts[index]);
    }
}
