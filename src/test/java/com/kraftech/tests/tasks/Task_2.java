package com.kraftech.tests.tasks;

public class Task_2 {
    //Which method would you use to learn if a string is a rotation of another string?
    //rotation of car->car, arc, rca
    //sarı->sarı,arıs,rısa,ısar  -->en baştaki harfin en sona geçmesiyle oluşan yeni kelime..sıra bozulmuyor
    //ve en fazla harf sayısı kadar oluyor.
    public static void main(String[] args) {
       // String str = "araba";
        String str1 = "yaman";
        String str2 = "manya";

       // System.out.println(rotatedMethod(str));
        System.out.println(isRotation(str1, str2));
        System.out.println(isRotation1(str1, str2));
    }
//Benim çözdüğüm soru:

    public static String rotatedMethod(String str) {

        //if bloğu str.substring(0,i); metodunun hata vermemesi için yazıldı
        if (str.isEmpty()) {
            return null;

        }
        int length = str.length();
        String target = "";

        for (int i = 0; i < length; i++) {
            String rotatedWord = str.substring(i) + str.substring(0, i);
            target += rotatedWord;


            //Sonddaki virgülün yazmaması için
            if (i != length - 1) {
                target += ",";
            }

        }

        return target;
    }
    //Hocanın çözdüğü soru:

    public static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;

        }
        for (int i = 0; i < str1.length(); i++) {
            str1 = str1.substring(1) + str1.substring(0, 1);
            if (str1.equals(str2)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isRotation1(String str1,String str2){
        if (str1.length() != str2.length()) {
            return false;
        }
                return (str1+str1).contains(str2);
    }


}




