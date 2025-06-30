package ch.unisg.sat.core.domain.aggregate;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArchitecturalDecisions {

    private final List<ArchitectureDecision> value = new ArrayList<>();

    private ArchitecturalDecisions() { }

    public static ArchitecturalDecisions create() {
        return new ArchitecturalDecisions();
    }
}
