package com.group6;

public class TextCoverter {

    public static String convertEveryFirstLetterToUpperCase(String str){

        String result="";

        str = str.replace("()([A-Z])","$1 $2");

        String[] words = str.split(" ");

        for(String word:words){

            result+=Character.toUpperCase(word.charAt(0))+word.substring(1).toLowerCase()+" ";

        }

        return result;

    }
}
