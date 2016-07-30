package models;

/**
 * Created by Tim on 7/30/2016.
 */
public class Id extends Token {
    private String value;

    public Id(String value) {
        super(TokenType.ID);

        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + value;
    }
}
