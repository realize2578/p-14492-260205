package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        lab2();

    }
    public static void lab2(){
        PrintStream ORIGINAL_OUT = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        System.out.println("hihi");
        System.out.println("byebye");
        System.out.println("ok");

        System.setOut(ORIGINAL_OUT);

        String result = byteArrayOutputStream.toString();

        if(result.equals("1번 명언이 등록되었습니다.")){

        }

        System.out.println(result);;
    }


    public static void lab1(){
        Scanner sc = new Scanner("""
                등록
                과거에 집착하지 마라.
                작자미상
                """);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str2);

    }
}