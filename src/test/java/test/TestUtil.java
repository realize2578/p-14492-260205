package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {

//    public static String run(String input){
//        //입력값
//        Scanner sc = genScanner(input);
//
//        //명언 프로글매 설정
//
//        // 출력값
//    }

    private static PrintStream ORIGINAL_OUT = System.out;
    private static PrintStream CURRENT_OUT = System.out;

    public static Scanner genScanner(String input){
        return new Scanner(input);
    }

    public static ByteArrayOutputStream setOutByteArray(){



        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);
        CURRENT_OUT = printStream;

        return byteArrayOutputStream;
    }

    public static void clearSetOutTOByteArray(ByteArrayOutputStream outputStream) {
        System.setOut(ORIGINAL_OUT);
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CURRENT_OUT.close();

    }


}
