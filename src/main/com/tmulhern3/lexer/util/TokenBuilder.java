package com.tmulhern3.lexer.util;

import models.Token;
import models.TokenType;

/**
 * Created by Tim on 7/30/2016.
 */
public class TokenBuilder {

    public static Token buildTokenFromReservedWord(String reservedWord) {
        switch (reservedWord) {
            case "begin":
                return new Token(TokenType.BEGIN);
            case "end":
                return new Token(TokenType.END);
            case "provider":
                return new Token(TokenType.PROVIDER);
            case "server":
                return new Token(TokenType.SERVER);
            case "id":
                return new Token(TokenType.ID);
        }
        return null;
    }

    public static Token buildTokenFromCharacter(char character) {
        switch (character) {
            case '(':
                return new Token(TokenType.LPAREN);
            case ')':
                return new Token(TokenType.RPAREN);
            case '=':
                return new Token(TokenType.EQ);
        }
        throw new RuntimeException("Invalid character " + character + "!");
    }
}
