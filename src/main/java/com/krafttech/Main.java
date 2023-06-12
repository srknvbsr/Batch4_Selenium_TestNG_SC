package com.krafttech;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
         /* Java sorusu: Milano'dan yapılan bir tester interviewde sorulmuş..
        String str="128 2 3693 65 89 25 10" str içerisindeki
         boşlukla ayrılmış sayıların sayı değerleri toplanarak
         küçükten büyüğe dizili olarak yeniden bir stringe tanımlayan metod nedir?
         Bu soru için cevap String result="1 2 7 11 11 17 21" şeklinde olmalıdır.

          */
        String str = "128 2 3693 65 89 25 10";
        System.out.println("sumOfString(str) = " + sumOfString(str));


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
}
