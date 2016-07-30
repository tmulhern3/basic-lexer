package com.tmulhern3.lexer;

import com.tmulhern3.lexer.util.TokenBuilder;
import models.Token;
import models.Id;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lexer {
    static Logger logger = Logger.getLogger(Lexer.class.getName());

    private static Set<String> reservedWords = new HashSet();
    private static TokenBuilder tokenBuilder = new TokenBuilder();

    private static void initializeLexer() {
        reservedWords.add("begin");
        reservedWords.add("end");
        reservedWords.add("provider");
        reservedWords.add("server");
        reservedWords.add("id");
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            logger.log(Level.SEVERE, "Must specify input source");

            System.exit(1);
        }
        initializeLexer();

        String filename = args[0];
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            Token token;
            while((token = nextToken(reader)) != null) {
                logger.log(Level.INFO, token.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Token nextToken(BufferedReader reader) {
        try {
            int c;
            while ((c = reader.read()) != -1) {
                char peek = (char) c;
                if (peek == 0x20 || peek == 0x0D || peek == 0x0A) {
                    continue;
                }
                if (Character.isLetter(peek)) {
                    StringBuffer sb = new StringBuffer();
                    do {
                        sb.append(peek);
                        peek = (char) reader.read();
                    } while (Character.isLetterOrDigit(peek));
                    if (reservedWords.contains(sb.toString())) {
                        return tokenBuilder.buildTokenFromReservedWord(sb.toString());
                    }
                    return new Id(sb.toString());
                } else {
                    return tokenBuilder.buildTokenFromCharacter(peek);
                }
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, e.toString());

            return null;
        }

        return null;
    }
}