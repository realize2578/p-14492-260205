package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTestFileTest {


    @Test
    @DisplayName("TestUtil.genScanner")
    public void t1(){
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑하라
                작자미상
                """);

        String cmd = sc.nextLine();
        String content = sc.nextLine();
        String auther = sc.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("현재를 사랑하라");
        assertThat(auther).isEqualTo("작자미상");


    }
    @Test
    @DisplayName("TestUtil.setOutByteArray()")
    public void t2() throws Exception {

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutByteArray();

        System.out.println("1 / 이순신 / 나의 죽음을 알리지 마라.");

        String result = byteArrayOutputStream.toString();


        // 모니터로 확인하고 싶은 시점
        TestUtil.clearSetOutTOByteArray(byteArrayOutputStream);

        System.out.println(result);

        assertThat(result).contains("1 / 이순신 / 나의 죽음을 알리지 마라."); // 문자열끼리 비교할 땐 contains를 더 많이 쓴다.

    }







}
