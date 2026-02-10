package org.example.wiseSaying.repository;

import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.entity.WiseSaying;

public class WiseSayingFileRepository {
    public WiseSaying save(WiseSaying wiseSaying) {
        return wiseSaying;
    }

    public WiseSaying findByIdOrNull(int id) {
        return null;
    }
}
