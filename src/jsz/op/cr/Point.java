package jsz.op.cr;

/*
    Most basic complex object of this project
    Point represents one or more lines of pure text.
*/

public class Point extends AbstractConstitutionObject{
    private int number;
    private String text;

    public Point(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}
