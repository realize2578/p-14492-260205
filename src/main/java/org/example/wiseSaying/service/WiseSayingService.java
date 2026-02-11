package org.example.wiseSaying.service;

import org.example.global.AppContext;
import org.example.wiseSaying.dto.PageDto;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.Optional;

public class WiseSayingService {
    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public PageDto findListDesc(String keyword, String keywordType, int page, int pageSize) {
//        return wiseSayingRepository.findListDesc();
        return switch (keywordType){
            case "content" -> wiseSayingRepository.findByContentContainingDesc(keyword,page,pageSize);
            case "author" -> wiseSayingRepository.findByAuthorContainingDesc(keyword,page,pageSize);
            default -> wiseSayingRepository.findAll(page,pageSize);
        };
    }

    public boolean delete(int id) {
        Optional<WiseSaying> wiseSayingOp = wiseSayingRepository.findById(id);
        if(wiseSayingOp.isPresent())return wiseSayingRepository.delete(wiseSayingOp.get());
        else return false;
    }

// Optional로 하면 좋다 Optional<WiseSaying>
    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findById(id).orElse(null);
    }

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {

        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }
}
