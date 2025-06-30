package ch.unisg.sat.core.domain.entities.classes.ar;

import ch.unisg.sat.infrastructure.repository.sdn.node.ArchitectureRequirementNode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ArchitectureRequirement {

    public enum TargetType {
        CONSTRAINT,
        ARCHITECTURE_PRINCIPLE,
        INTENTION,
        NON_FUNCTIONAL_REQUIREMENT,
        UNKNOWN
    }

    public static TargetType fromLabel(String label) {
        return switch (label.toUpperCase()) {
            case "CONSTRAINT" -> TargetType.CONSTRAINT;
            case "ARCHITECTUREPRINCIPLE", "ARCHITECTURE_PRINCIPLE" -> TargetType.ARCHITECTURE_PRINCIPLE;
            case "INTENTION" -> TargetType.INTENTION;
            case "NONFUNCTIONALREQUIREMENT", "NON_FUNCTIONAL_REQUIREMENT" -> TargetType.NON_FUNCTIONAL_REQUIREMENT;
            default -> TargetType.UNKNOWN;
        };
    }

    private UUID id;
    private String title;
    private int value;
    private TargetType targetType;

    private ArchitectureRequirement(
            UUID id,
            String title,
            int value,
            TargetType targetType
    ) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.targetType = targetType;
    }

    public static ArchitectureRequirement create(UUID id) {
        return new ArchitectureRequirement(id, "", 0, TargetType.UNKNOWN);
    }

    public static ArchitectureRequirement create(UUID id, String title, int value, ArchitectureRequirementNode.TargetType targetType) {
        return new ArchitectureRequirement(id, title, value, fromLabel(targetType.toString()));
    }


    public static <T> ArchitectureRequirement create(
            UUID id,
            String title,
            T architectureRequirementType
    ) {

        switch (architectureRequirementType) {
            case Constraint constraint -> {
                return new ArchitectureRequirement(id, title, 0, TargetType.CONSTRAINT);
            }
            case ArchitecturePrinciple architecturePrinciple -> {
                return new ArchitectureRequirement(id, title, 0, TargetType.ARCHITECTURE_PRINCIPLE);
            }
            case Intention intention -> {
                return new ArchitectureRequirement(id, title,0, TargetType.INTENTION);
            }
            case NonFunctionalRequirement nonFunctionalRequirement -> {
                return new ArchitectureRequirement(id, title, 0, TargetType.NON_FUNCTIONAL_REQUIREMENT);
            }
            case null, default -> {
                System.out.println("Architecture requirement not found");
                return null;
            }

        }
    }

}
