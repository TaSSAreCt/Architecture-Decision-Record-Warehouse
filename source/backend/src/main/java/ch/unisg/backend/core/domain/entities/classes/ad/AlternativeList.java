package ch.unisg.backend.core.domain.entities.classes.ad;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class AlternativeList {

    private final List<Alternative> alternativeList;

    public AlternativeList() {
        this.alternativeList = new ArrayList<>();
    }

    public static AlternativeList create() {
        return new AlternativeList();
    }

    public void add(Alternative a) {
        if (a != null) {
            alternativeList.add(a);
        }
    }

    public List<HashMap<String, String>>  toJSON() {

        List<HashMap<String, String>> result = new ArrayList<>();

        for (Alternative alternative : alternativeList) {

            HashMap<String, String> map = new HashMap<>();
            map.put("id", alternative.getId().toString());
            map.put("title", alternative.getTitle());

            result.add(map);
        }

        return result;
    }

    public void remove(Alternative a) {
        alternativeList.remove(a);
    }

}
