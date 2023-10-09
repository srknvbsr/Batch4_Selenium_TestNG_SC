package com.kraftech.tests.tasks;

public class Task_3 {
    public static void main(String[] args) {
        String str = "kasık";
        System.out.println(rotateString(str));
    }

    public static String rotateString(String str) {
        int length = str.length();
        String rotatedString = "";

        for (int i = 0; i < length; i++) {
            String rotatedWord = str.substring(i) + str.substring(0, i);
            rotatedString += rotatedWord;

            if (i != length - 1) {
                rotatedString += ",";
            }
        }

        return rotatedString;
    }
}


