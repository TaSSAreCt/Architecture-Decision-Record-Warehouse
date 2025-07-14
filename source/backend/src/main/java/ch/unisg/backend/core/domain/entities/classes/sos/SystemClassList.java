package ch.unisg.backend.core.domain.entities.classes.sos;

import lombok.Getter;

import java.util.*;

@Getter
public class SystemClassList {

    private final List<SystemClass> systemClassList;

    private SystemClassList() {
        this.systemClassList = new ArrayList<>();
    }

    public static SystemClassList create() {
        return new SystemClassList();
    }

    public void add(SystemClass e) {
        if (e != null) {
            this.systemClassList.add(e);
        }
    }

    public void remove(SystemClass e) {
        this.systemClassList.remove(e);
    }

    public Optional<SystemClass> getElement(UUID id) {
        for (SystemClass systemclass : systemClassList) {
            if (systemclass.getId().equals(id)) {
                return Optional.of(systemclass);
            }
        }
        return Optional.empty();
    }
}
