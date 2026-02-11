package org.example;

import org.example.global.AppConfig;
import org.example.global.AppContext;

public class Main {

    public static void main(String[] args) {


        AppConfig.setDevMode();
        AppContext.init();
        new App().run();

    }
}