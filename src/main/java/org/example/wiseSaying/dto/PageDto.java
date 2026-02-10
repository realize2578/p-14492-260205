package org.example.wiseSaying.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageDto {

    private int page;
    private int pageSize;
    private int totalCount;
    private List<WiseSaying> content;

    public int getPageCount() {
        return (int)Math.ceil((double)totalCount / pageSize);
    }

}
