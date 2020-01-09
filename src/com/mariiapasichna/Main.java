package com.mariiapasichna;

public class Main {

    /*1. Не используя методы String - contains, indexOf, 	lastIndexOf определить входит ли подстрока в строку.
    1.1. Найти все вхождения подстроки в строку. Подумать как оптимизировать код для того чтобы он быстро выполнялся
    для больших строк(книга).*/

    public static void main(String[] args) {
        String pattern = "hello";
        String text = "Hello java, hello java";

        if (StringSeach.performSearch(text, pattern).isEmpty()) {
            System.out.println("Pattern isn't found in the given text");
        } else {
            System.out.println("Pattern is found in the given text at positions: " + StringSeach.performSearch(text, pattern));
        }
    }
}