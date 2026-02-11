package org.example.wiseSaying.repository;

import org.example.wiseSaying.dto.PageDto;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.Optional;

public interface WiseSayingRepository {

    Optional<WiseSaying> findById(int id);

    PageDto findAll(int page, int pageSize);

    WiseSaying save(WiseSaying wiseSaying);

    boolean delete(WiseSaying wiseSaying);

    PageDto findByContentContainingDesc(String keyword, int page, int pageSize);

    PageDto findByAuthorContainingDesc(String keyword, int page, int pageSize);

}
