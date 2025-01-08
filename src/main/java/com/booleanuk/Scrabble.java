package com.booleanuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Scrabble {
    HashMap<ArrayList<String>, Integer> map = new HashMap<>();

    /*ArrayList<String> point1 = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'));
    ArrayList<String> point2 = new ArrayList<>(Arrays.asList('D', 'G'));
    ArrayList<String> point3 = new ArrayList<>(Arrays.asList('B', 'C', 'M', 'P'));
    ArrayList<String> point4 = new ArrayList<>(Arrays.asList('F', 'H', 'V', 'W', 'Y'));
    ArrayList<String> point5 = new ArrayList<>(Arrays.asList('K'));
    ArrayList<String> point8 = new ArrayList<>(Arrays.asList('J', 'X'));
    ArrayList<String> point10 = new ArrayList<>(Arrays.asList('Q', 'Z'));*/

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
                        if(!word.matches("a-zA-Z")){

                        }


                        if(aString.toLowerCase().charAt(0)==(word.toLowerCase().charAt(i))){
                            points = points + map.get(listOfChars);
                            System.out.println( "nu blev det " + map.get(listOfChars) + "poäng! för bokstaven: " + aString);
                            System.out.println("Tot poäng: " + points);



                            if(i > 0 && i < word.length() -1){
                                if(word.charAt(i-1) == '{' && word.charAt(i+1) == '}'){
                                    points = points + map.get(listOfChars);
                                    System.out.println( "nu blev det " + map.get(listOfChars) + "poäng! för bokstaven: " + aString + "Dubbelpoäng");
                                    System.out.println("Tot poäng: " + points);
                                }
                                else if(word.charAt(i-1) == '[' && word.charAt(i+1) == ']'){
                                    points = points + map.get(listOfChars)*2;
                                    System.out.println( "nu blev det " + map.get(listOfChars) + "poäng! för bokstaven: " + aString+ "Trippelpoäng");
                                    System.out.println("Tot poäng: " + points);
                                }
                            }
                        }




                        // för extension
                        /*
                        if(i == 0 && word.charAt(0) == '{' && word.charAt(2) == '}'){
                            if(listOfChars.contains(String.valueOf(word.charAt(i+1)).toUpperCase())){
                                points = points + map.get(listOfChars)*2;
                                System.out.println( "nu blev det dubbelpoäng!" + points);

                            }
                        }
                        else if(i <= word.length()-2 && word.charAt(i) == '{' && word.charAt(i+2) == '}'){
                            if(aString.equals(String.valueOf(word.charAt(i+1)).toUpperCase())){
                                points = points + map.get(listOfChars)*2;
                                System.out.println( "nu blev det dubbelpoäng!" + points);

                            }

                        }
                        else if(i == 0 && word.charAt(0) == '[' && word.charAt(2) == ']'){
                            if(listOfChars.contains(String.valueOf(word.charAt(i+1)).toUpperCase())){
                                points = points + map.get(listOfChars)*3;

                            }
                        }
                        else if(i <= word.length()-2 && word.charAt(i) == '[' && word.charAt(i+2) == ']'){
                            if(listOfChars.contains(String.valueOf(word.charAt(i+1)).toUpperCase())){
                                points = points + map.get(listOfChars)*3;

                            }
                        }*/

                    }

                }
            }
            if(word.charAt(0) == '{' && word.charAt(word.length()-1) == '}'){
                points = points*2;
                System.out.println("dubbelord!");
                if(word.charAt(1) == '[' && word.charAt(word.length()-2) == ']'){
                    points = points*3;
                    System.out.println("trippelord!");
                }
            }
            if(word.charAt(0) == '[' && word.charAt(word.length()-1) == ']'){
                points = points*3;
                System.out.println("trippelord!");
                if(word.charAt(0) == '{' && word.charAt(word.length()-1) == '}'){
                    points = points*2;
                    System.out.println("dubbelord!");
                }
            }

        }


    }



    public int score() {
        return points;
    }

}
