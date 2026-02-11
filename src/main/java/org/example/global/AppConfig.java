package org.example.global;

import lombok.Getter;

public class AppConfig { // 전역적인 설정값

    @Getter
    private static String mode;

    public static void setTestMode() {
        AppConfig.mode = "test";
    }

    public static void setDevMode() {
        AppConfig.mode = "dev";
    }
}
