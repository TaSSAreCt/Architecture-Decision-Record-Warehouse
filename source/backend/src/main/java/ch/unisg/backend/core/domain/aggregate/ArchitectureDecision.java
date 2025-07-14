package ch.unisg.backend.core.domain.aggregate;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ArchitectureDecision {

    @Getter @Setter
    private Issue issue = Issue.create();

    @Setter
    private AlternativeAggregate selectedAlternative;

    @Getter
    private final List<AlternativeAggregate> alternativeAggregates = new ArrayList<>();

    private ArchitectureDecision() {}

    public static ArchitectureDecision create() {
        return new ArchitectureDecision();
    }
}
