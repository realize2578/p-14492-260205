package org.example;

import org.example.global.AppContext;
import org.example.global.Rq;
import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private WiseSayingController wiseSayingController;
    private SystemController systemController;

    public App() {
        this.sc = AppContext.sc;
        this.wiseSayingController = AppContext.wiseSayingController;
        this.systemController = AppContext.systemController;
    }

    public void run() {


        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.println("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd);
            String action = rq.getActionName();

            switch (action) {
                case "등록" -> wiseSayingController.actionAdd();
                case "목록" -> wiseSayingController.actionList(rq);
                case "삭제" -> wiseSayingController.actionDelete(rq);
                case "수정" -> wiseSayingController.actionModify(rq);
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }
    }
}
