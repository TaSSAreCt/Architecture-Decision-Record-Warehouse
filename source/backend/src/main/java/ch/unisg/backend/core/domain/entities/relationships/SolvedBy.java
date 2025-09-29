package ch.unisg.backend.core.domain.entities.relationships;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class SolvedBy {

    private UUID id;
    private Alternative alternative;
    private Issue issue;

    public SolvedBy(UUID id, Alternative alternative, Issue issue) {
        this.id = id;
        this.alternative = alternative;
        this.issue = issue;
    }

    public SolvedBy(Alternative alternative, Issue issue) {
        this.alternative = alternative;
        this.issue = issue;
    }

    public static SolvedBy create(Alternative alternative, Issue issue) {
        return new SolvedBy(UUID.randomUUID(), alternative, issue);
    }

    public static SolvedBy create(UUID id, Alternative alternative, Issue issue) {
        return new SolvedBy(id, alternative, issue);
    }
}
