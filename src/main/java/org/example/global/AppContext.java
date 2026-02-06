package org.example.global;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.repository.WiseSayingRepository;
import org.example.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {

    public static Scanner sc;
    public static SystemController systemController;
    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService;
    public static WiseSayingRepository wiseSayingRepository;


    public static void init(Scanner _sc) {
        AppContext.sc = _sc;
        AppContext.wiseSayingRepository = new WiseSayingRepository();
        AppContext.wiseSayingService = new WiseSayingService();
        AppContext.wiseSayingController = new WiseSayingController();
        AppContext.systemController = new SystemController();
    }

    public static void init() {
        init(new Scanner(System.in));
    }

}
