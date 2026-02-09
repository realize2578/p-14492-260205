package org.example.wiseSaying.repository;

import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }


    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<WiseSaying> findListDesc(int page, int pageSize) {
        return wiseSayings.reversed()
                .stream()
                .skip(page*pageSize)
                .limit(pageSize)
                .toList();
    }

    public List<WiseSaying> findByContentKeywordOrderByDesc(String keyword,int page, int pageSize) {
        return wiseSayings
                .reversed()
                .stream()
                .filter(wiseSaying -> wiseSaying.getSaying().contains(keyword))
                .skip(page*pageSize)
                .limit(pageSize)// 결과가 나온 다음 페이징
                .toList();
    }

    public List<WiseSaying> findByAutherKeywordOrderByDesc(String keyword,int page, int pageSize) {
        return wiseSayings
                .reversed()
                .stream()
                .filter(wiseSaying -> wiseSaying.getAuthor().contains(keyword))
                .skip(page*pageSize)
                .limit(pageSize)
                .toList();
    }
}
