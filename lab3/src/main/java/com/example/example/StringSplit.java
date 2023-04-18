package com.example.example;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
    public StringSplit() {
    }
    public String[] split(String line, char symbol){
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == symbol && currentToken.length() > 0) {
                tokens.add(currentToken.toString());
                currentToken = new StringBuilder();
            } else {
                currentToken.append(c);
            }
        }
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }
        String[] tokensArray = tokens.toArray(new String[0]);
        return tokensArray;
    }
}
