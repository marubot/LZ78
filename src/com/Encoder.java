package com;

import java.util.ArrayList;
import java.util.HashMap;

public class Encoder {
    ArrayList<String> dictionary;
    String [] charstream;
    HashMap<Integer, String> code_word;
    String currentPrefix;
    String currentCharacter;
    int index;
    int key;

    Encoder(String stream) {
        charstream = stream.split("");
        index = 0;
        code_word = new HashMap<Integer,String>();
        currentPrefix = "";
        dictionary = new ArrayList<String>();
        key = 0;
    }

    void encode() {
        while(index < charstream.length) {
             currentCharacter = charstream[index];
            if(dictionary.contains(currentPrefix.concat(currentCharacter))) {
                currentPrefix = currentPrefix.concat(currentCharacter);
            }
            else {
                if(currentPrefix.isEmpty()) {
                    code_word.put(key,"0" + ":" + currentCharacter);
                    key++;
                }
                else {
                    code_word.put(key, dictionary.indexOf(currentPrefix) + ":" + currentCharacter);
                    key++;
                }
                dictionary.add(currentPrefix.concat(currentCharacter));
                currentPrefix = "";

            }
            index++;
        }
        if(index == charstream.length) {
            if(dictionary.contains(currentPrefix)) {
                code_word.put(key,dictionary.indexOf(currentPrefix) + ":" + "NULL");
            }
            else {
                dictionary.add(currentPrefix);
            }
            System.out.println(code_word);
        }
    }




}