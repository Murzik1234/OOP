package com.example.example;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
    public StringSplit() {

    }

    public String[] split(String line, char symbol) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean escape = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == symbol && !escape) {
                tokens.add(currentToken.toString());
                currentToken = new StringBuilder();
            } else {
                currentToken.append(c);
                escape = (c == '\\');
            }
        }
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }
        String[] tokensArray = tokens.toArray(new String[0]);
        return tokensArray;
    }

    public String remove(String input) {
        StringBuilder str = new StringBuilder(input);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c == '{' || c == '}' || c == ':'||c == ',') && str.charAt(i - 1) == '\\'){
                str.deleteCharAt(i - 1);
            }
        }
        return str.toString();
    }

    public String removeSingleBackslashes(String input) {
        input = remove(input);
        StringBuilder sb = new StringBuilder();
        boolean previousCharIsBackslash = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '\\') {
                if (previousCharIsBackslash) {
                    sb.append("\\");
                    previousCharIsBackslash = false;
                } else {
                    previousCharIsBackslash = true;
                }
            } else {
                if (previousCharIsBackslash) {
                    sb.append("\\");
                }
                sb.append(c);
                previousCharIsBackslash = false;
            }
        }
        if (previousCharIsBackslash) {
            sb.append("\\");
        }
        return sb.toString();
    }
}




