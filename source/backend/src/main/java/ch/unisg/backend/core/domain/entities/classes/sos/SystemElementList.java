package ch.unisg.backend.core.domain.entities.classes.sos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemElementList {

    private final List<SystemElement> systemElementList;

    public SystemElementList() {
        this.systemElementList = new ArrayList<>();
    }

    public static SystemElementList create() {
        return new SystemElementList();
    }

    public List<HashMap<String, String>>  toJSON() {

        List<HashMap<String, String>> result = new ArrayList<>();

        for (SystemElement systemElement : systemElementList) {

            HashMap<String, String> map = new HashMap<>();
            map.put("id", systemElement.getId().toString());
            map.put("title", systemElement.getTitle());

            result.add(map);
        }

        return result;
    }

    public void add(SystemElement e) {
        if (e != null) {
            this.systemElementList.add(e);
        }
    }

    public void remove(SystemElement e) {
        this.systemElementList.remove(e);
    }

}
