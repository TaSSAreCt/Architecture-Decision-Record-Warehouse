package ch.unisg.sat.core.domain.entities.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class MetaClass {

    @Setter @Getter
    private UUID id;

    @Setter @Getter
    private String title;

    public MetaClass() {}

    public MetaClass(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public MetaClass(String title) {
        this.title = title;
    }

    public MetaClass(UUID id) {
        this.id = id;
    }
}
