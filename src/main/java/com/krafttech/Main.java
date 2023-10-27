package com.krafttech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         /* Java sorusu: Milano'dan yapılan bir tester interviewde sorulmuş..
        String str="128 2 3693 65 89 25 10" str içerisindeki
         boşlukla ayrılmış sayıların sayı değerleri toplanarak
         küçükten büyüğe dizili olarak yeniden bir stringe tanımlayan metod nedir?
         Bu soru için cevap String result="1 2 7 11 11 17 21" şeklinde olmalıdır.

          */
        /*
        String str = "128 2 3693 65 89 25 10";
        System.out.println("sumOfString(str) = " + sumOfString(str));
         */

/*
        String str1 = "red24 blue54 black188 green33 gold33";
        System.out.println("orderColors_1(str1) = " + orderColors_1(str1));

 */

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println("list = " + list);

        System.out.println("list.stream().distinct().count() = " + list.stream().distinct().toList());

        list.removeIf(e->e<=7);
        System.out.println("list = " + list);


    }

    public static String sumOfString(String str) {
        String[] strArray = str.split(" ");
        int sum = 0;
        String result = "";

        int[] intArr = new int[strArray.length];


        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length(); j++) {
                sum += Integer.parseInt(strArray[i].substring(j, j + 1));
                // sum += Integer.parseInt(strArray[i].charAt(j)+"");
                // sum += Character.getNumericValue(strArray[i].charAt(j));

            }
            intArr[i] = sum;
            sum = 0;

        }
        Arrays.sort(intArr);

        for (int i : intArr) {
            result += i + " ";

        }
        return result.trim();

    }
    //result-->black red green gold blue

    public static String orderColors(String str) {
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(words[i].length() - 1) + words[i];
        }
        Arrays.sort(words);
        //  System.out.println("Arrays.toString(words) = " + Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replace(words[i].substring(0, 1), "");
        }

        // System.out.println("Arrays.toString(words) = " + Arrays.toString(words));

    /*    String result="";
        for (String word : words) {
            result+=word+" ";
        }
        return result.trim();*/

        String joined = String.join(" ", words);

        return joined;

    }


    //String str = "red24 blue54 black188 green33 gold33";
    public static String orderColors_1(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (Integer.parseInt(words[i].replaceAll("[^0-9]", "")) >
                        Integer.parseInt(words[j].replaceAll("[^0-9]", ""))) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;

                }
            }

        }
        System.out.println("Arrays.toString(words) = " + Arrays.toString(words));
        String joined = String.join(" ", words).replaceAll("[0-9]", "");
        return joined;
    }
}
