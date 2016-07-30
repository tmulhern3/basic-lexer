package com.tmulhern3.lexer;

import models.Token;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lexer {
    static Logger logger = Logger.getLogger(Lexer.class.getName());

    public static void main(String[] args) {
        if (args.length != 1) {
            logger.log(Level.SEVERE, "Must specify input source");

            System.exit(1);
        }

        String filename = args[0];
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            nextToken(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Token nextToken(BufferedReader reader) {
        try {
            int c;
            while ((c = reader.read()) != -1) {
                char character = (char) c;
                if (character == 0x20) {
                    System.out.println("WHITESPACE");
                    continue;
                }
                System.out.println("NONWHITESPACE");
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, e.toString());

            return null;
        }

        return null;
    }
}