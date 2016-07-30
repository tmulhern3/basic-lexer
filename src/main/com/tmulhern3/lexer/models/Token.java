package models;

/**
 * Created by Tim on 7/30/2016.
 */
public class Token {
    private TokenType tokenType;

    public Token(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String toString() {
        return tokenType.toString();
    }
}
