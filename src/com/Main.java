package com;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {
            String file = "string.txt";
            Scanner scanner = new Scanner(new File("string.txt"));
            String  word = null;
            while(scanner.hasNext()) {
               word = scanner.useDelimiter("\\A").next();
            }
            scanner.close();
            Encoder en = new Encoder(word);
            en.encode();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

}
