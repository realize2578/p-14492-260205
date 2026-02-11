package org.example.global;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.repository.WiseSayingFileRepository;
import org.example.wiseSaying.repository.WiseSayingMemRepository;
import org.example.wiseSaying.repository.WiseSayingRepository;
import org.example.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {

    public static Scanner sc;
    public static SystemController systemController;
    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService;
    public static WiseSayingMemRepository wiseSayingMemRepository;
    public static WiseSayingFileRepository wiseSayingFileRepository;
    public static WiseSayingRepository wiseSayingRepository;


    public static void init(Scanner _sc, boolean isFileMode) {
        AppContext.sc = _sc;
        AppContext.wiseSayingFileRepository = new WiseSayingFileRepository();
        AppContext.wiseSayingMemRepository = new WiseSayingMemRepository();
        AppContext.wiseSayingRepository = isFileMode ? wiseSayingFileRepository:wiseSayingMemRepository;
        AppContext.wiseSayingService = new WiseSayingService();
        AppContext.wiseSayingController = new WiseSayingController();
        AppContext.systemController = new SystemController();
    }

    public static void init() {
        init(new Scanner(System.in),true);
    }

}
