import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {


    @Test
    @DisplayName("등록")
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








}
