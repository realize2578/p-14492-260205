package app;

import org.example.App;
import org.example.global.AppContext;
import test.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input){

        Scanner sc = TestUtil.genScanner(input+"\n종료");

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();

        AppContext.init(sc);
        new App().run();
        try {
            TestUtil.clearSetOutTOByteArray(outputStream);
        }catch (Exception e){
            throw new RuntimeException();
        }

        System.out.println(outputStream);

        return outputStream.toString();



    }



}
