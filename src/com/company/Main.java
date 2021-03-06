package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */

public class Main {


    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }


    public static void main (String[] args) {
        System.out.println("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCounter());

    }

    public static int wordCounter(){
        String a = urlToString("http://erdani.com/tdpl/hamlet.txt");
        if (a == null || a.isEmpty()){
            return 0;
        }

        String[] textArray = a.split("\\s+");
        int count = 0;
        for (int i = 0; i < textArray.length; i++){
            if ((textArray[i].toUpperCase()).contains("A")){
                count++;
            }


        }
        return count;


    }
}



