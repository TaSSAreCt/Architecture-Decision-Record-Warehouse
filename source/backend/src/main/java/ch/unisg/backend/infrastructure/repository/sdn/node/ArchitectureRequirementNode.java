package ch.unisg.backend.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchitectureRequirementNode {

    public enum TargetType {
        CONSTRAINT,
        ARCHITECTURE_PRINCIPLE,
        INTENTION,
        NON_FUNCTIONAL_REQUIREMENT,
        UNKNOWN
    }

    private String id;
    private String title;
    private double value;
    private TargetType targetType;

    private ConstraintNode constraintNode;
    private IntentionNode intentionNode;
    private ArchitecturePrincipleNode architecturePrincipleNode;
    private NonFunctionalRequirementNode nonFunctionalRequirementNode;

    public ArchitectureRequirementNode(String id, String title, double value, TargetType targetType) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.targetType = targetType;
    }

    public static ArchitectureRequirementNode create() {
        return new ArchitectureRequirementNode(null, null, 0, TargetType.UNKNOWN);
    }
    public static ArchitectureRequirementNode create(String id, String title, TargetType targetType) {
        return new ArchitectureRequirementNode(id, title, 0, targetType);
    }
    public static ArchitectureRequirementNode create(String id, String title, double value, TargetType targetType) {
        return new ArchitectureRequirementNode(id, title, value, targetType);
    }


}
