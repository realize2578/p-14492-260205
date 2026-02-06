import java.io.ByteArrayOutputStream;
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

    public static Scanner genScanner(String input){
        return new Scanner(input);
    }
    public static ByteArrayOutputStream setOutByteArray(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        return byteArrayOutputStream;
    }


}
