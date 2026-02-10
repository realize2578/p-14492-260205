package org.example.wiseSaying.repository;

import org.example.standard.util.Util;
import org.example.wiseSaying.dto.PageDto;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WiseSayingFileRepository {

    public WiseSaying save(WiseSaying wiseSaying) {

        if (wiseSaying.isNew()) {

            increaseLastId();
            int lastId = getLastId();

            wiseSaying.setId(lastId);
            Map<String, Object> wiseSayingMap = wiseSaying.toMap();
            String jsonStr = Util.json.toString(wiseSayingMap);
            Util.file.set("%s/%d.json".formatted(getDbPath(),wiseSaying.getId()), jsonStr);
            return wiseSaying;
        }

        String jsonStr = Util.json.toString(wiseSaying.toMap());
        Util.file.set("%s/%d.json".formatted(getDbPath(), wiseSaying.getId()), jsonStr);

        return wiseSaying;
    }

    private int getLastId() {
        return Util.file.getAsInt("%s/lastId.txt".formatted(getDbPath()), 0);
    }

    private void increaseLastId() {
        Util.file.set("%s/lastId.txt".formatted(getDbPath()), String.valueOf(getLastId() + 1));
    }

    public Optional<WiseSaying> findById(int id) {
        String jsonStr = Util.file.get("%s/%d.json".formatted(getDbPath(),id), "");
        if( jsonStr.isBlank()) {
            return Optional.empty();
        }

        Map<String, Object> map = Util.json.toMap(jsonStr);
        return Optional.of(WiseSaying.fromMap(map));
    }

    public void clear() {
        Util.file.delete(getDbPath());
    }

    public String getDbPath(){
        return "db/wiseSaying";
    }

    public void delete(WiseSaying wiseSaying1) {
        Util.file.delete("%s/%d.json".formatted(getDbPath(),wiseSaying1.getId()));
    }


    public List<WiseSaying> findAll() {
        return Util.file.walkRegularFiles(getDbPath(), "^\\d+\\.json$")
                .map(path -> Util.file.get(path.toString(),""))
                .map(Util.json::toMap)
                .map(WiseSaying::fromMap)
                .toList();
    }

    public PageDto findByContentContainingDesc(String keyword, int page, int pageSize) {
        List<WiseSaying> wiseSayings= findAll().stream()
                .filter(wiseSaying -> wiseSaying.getSaying().contains(keyword))
                .toList();

        return  pageOf(wiseSayings,page,pageSize);
    }

    private PageDto pageOf(List<WiseSaying> filteredContent, int page, int pageSize){
        int totalCount = filteredContent.size();

        List<WiseSaying> pagedFilteredContent = filteredContent.reversed()
                .stream()
                .skip((page-1)*pageSize)
                .limit(pageSize)
                .toList();


        return new PageDto(page,pageSize,totalCount,pagedFilteredContent);
    }
}
