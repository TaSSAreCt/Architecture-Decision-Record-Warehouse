package ch.unisg.backend.core.domain.aggregate;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.domain.entities.classes.ar.ArchitectureRequirement;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArchitecturalKnowledge {

    private final List<Issue> issueList = new ArrayList<>();
    private final ArchitectureRequirement architectureRequirement;

    private ArchitecturalKnowledge() {
        architectureRequirement = ArchitectureRequirement.create();
    }

    public static ArchitecturalKnowledge create() {
        return new ArchitecturalKnowledge();
    }

}
