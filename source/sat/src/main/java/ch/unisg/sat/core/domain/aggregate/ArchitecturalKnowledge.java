package ch.unisg.sat.core.domain.aggregate;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArchitecturalKnowledge {

    private final List<ArchitectureDecision> architectureDecisions = new ArrayList<>();

    private ArchitecturalKnowledge() {}

    public static ArchitecturalKnowledge create() {
        return new ArchitecturalKnowledge();
    }

}
