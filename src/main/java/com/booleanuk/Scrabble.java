package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Scrabble {
    HashMap<ArrayList<String>, Integer> map = new HashMap<>();

    ArrayList<String> point1 = new ArrayList<>(Arrays.asList("A", "E", "I", "O", "U", "L", "N", "R", "S", "T"));
    ArrayList<String> point2 = new ArrayList<>(Arrays.asList("D", "G"));
    ArrayList<String> point3 = new ArrayList<>(Arrays.asList("B", "C", "M", "P"));
    ArrayList<String> point4 = new ArrayList<>(Arrays.asList("F", "H", "V", "W", "Y"));
    ArrayList<String> point5 = new ArrayList<>(Arrays.asList("K"));
    ArrayList<String> point8 = new ArrayList<>(Arrays.asList("J", "X"));
    ArrayList<String> point10 = new ArrayList<>(Arrays.asList("Q", "Z"));
    int points = 0;

    public Scrabble(String word) {
        map.put(point1, 1);
        map.put(point2, 2);
        map.put(point3, 3);
        map.put(point4, 4);
        map.put(point5, 5);
        map.put(point8, 8);
        map.put(point10, 10);

        if(!word.trim().isEmpty()){

            for(ArrayList<String> listOfChars : map.keySet()){

                for(String aString : listOfChars){

                    for(int i = 0; i < word.length(); i++){

                        if(aString.toLowerCase().charAt(0)==(word.toLowerCase().charAt(i))){
                            points = points + map.get(listOfChars);

                            if(i > 0 && i < word.length() -1){
                                if(word.charAt(i-1) == '{' && word.charAt(i+1) == '}'){
                                    points = points + map.get(listOfChars);
                                }
                                else if(word.charAt(i-1) == '[' && word.charAt(i+1) == ']'){
                                    points = points + map.get(listOfChars)*2;
                                }
                            }
                        }
                    }
                }
            }
            if(word.charAt(0) == '{' && word.charAt(word.length()-1) == '}'){
                points = points*2;
                if(word.charAt(1) == '[' && word.charAt(word.length()-2) == ']'){
                    points = points*3;
                }
            }
            if(word.charAt(0) == '[' && word.charAt(word.length()-1) == ']'){
                points = points*3;
                if(word.charAt(0) == '{' && word.charAt(word.length()-1) == '}'){
                    points = points*2;
                }
            }
        }
    }



    public int score() {
        return points;
    }

}
