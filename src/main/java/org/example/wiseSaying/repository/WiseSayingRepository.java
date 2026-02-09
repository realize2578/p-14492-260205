package org.example.wiseSaying.repository;

import org.example.wiseSaying.dto.PageDto;
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

    public PageDto findListDesc(int page, int pageSize) {
        return pageOf(wiseSayings,page,pageSize);
    }

    public PageDto findByContentKeywordOrderByDesc(String keyword,int page, int pageSize) {



        List<WiseSaying> filteredContent = wiseSayings.reversed()
                .stream()
                .filter(w -> w.getSaying().contains(keyword))


                .toList();
        return pageOf(filteredContent,page,pageSize);
    }

    public PageDto findByAutherKeywordOrderByDesc(String keyword, int page, int pageSize) {
        List<WiseSaying> filteredContent = wiseSayings
                .reversed()
                .stream()
                .filter(wiseSaying -> wiseSaying.getAuthor().contains(keyword))
                .toList();

        return pageOf(filteredContent,page,pageSize);
    }
    private PageDto pageOf(List<WiseSaying> filteredContent, int page, int pageSize){
        int totalCount = filteredContent.size();

        List<WiseSaying> pagedFilteredContent = filteredContent.reversed()
                .stream()
                .skip(page)
                .limit(pageSize)
                .toList();


        return new PageDto(page,pageSize,totalCount,pagedFilteredContent);
    }
}
