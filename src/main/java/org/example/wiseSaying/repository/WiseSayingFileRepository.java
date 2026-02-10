package org.example.wiseSaying.repository;

import org.example.standard.util.Util;
import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.Map;

public class WiseSayingFileRepository {

    public WiseSaying save(WiseSaying wiseSaying) {

        if (wiseSaying.isNew()) {

            increaseLastId();
            int lastId = getLastId();

            wiseSaying.setId(lastId);
            Map<String, Object> wiseSayingMap = wiseSaying.toMap();
            String jsonStr = Util.json.toString(wiseSayingMap);
            Util.file.set("%s/%d.json".formatted(getDbPass(),wiseSaying.getId()), jsonStr);

        }

        return wiseSaying;
    }

    private int getLastId() {
        return Util.file.getAsInt("%s/lastId.txt".formatted(getDbPass()), 0);
    }

    private void increaseLastId() {
        Util.file.set("%s/lastId.txt".formatted(getDbPass()), String.valueOf(getLastId() + 1));
    }

    public WiseSaying findByIdOrNull(int id) {
        String jsonStr = Util.file.get("%s/%d.json".formatted(getDbPass(),id), "");
        if( jsonStr.isBlank()) {
            return null;
        }

        Map<String, Object> map = Util.json.toMap(jsonStr);
        return WiseSaying.fromMap(map);
    }

    public void clear() {
        Util.file.delete(getDbPass());
    }

    public String getDbPass(){
        return "db/wiseSaying";
    }
}
