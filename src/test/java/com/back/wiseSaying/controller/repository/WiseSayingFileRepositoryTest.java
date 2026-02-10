package com.back.wiseSaying.controller.repository;

import com.back.wiseSaying.controller.WiseSayingControllerTest;
import org.example.global.AppContext;
import org.example.wiseSaying.repository.WiseSayingFileRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WiseSayingFileRepositoryTest {
    private WiseSayingFileRepository wiseSayingFileRepository;



    public WiseSayingFileRepositoryTest(){
        AppContext.init();
        wiseSayingFileRepository = AppContext.wiseSayingFileRepository;
    }

    @Test
    @DisplayName("명언 저장")
    public void t1(){

    }
}
