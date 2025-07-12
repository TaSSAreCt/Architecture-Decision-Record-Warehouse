package ch.unisg.backend.core.domain.entities.relationships;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Raise {

    private UUID id;
    private Issue issue;
    private SystemClass systemClass;

    public Raise(UUID id, Issue issue, SystemClass systemClass) {
        this.id = id;
        this.issue = issue;
        this.systemClass = systemClass;
    }

    public static Raise create(UUID id, SystemClass systemClass, Issue issue) {
        return new Raise(id, issue, systemClass);
    }
}
