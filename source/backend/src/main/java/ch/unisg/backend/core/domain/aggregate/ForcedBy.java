package ch.unisg.backend.core.domain.aggregate;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class ForcedBy {

    private ArchitecturalRequirement architecturalRequirement;
    private double value;

    public ForcedBy(ArchitecturalRequirement architecturalRequirement, double value) {
        this.architecturalRequirement = architecturalRequirement;
        this.value = value;
    }

    public static ForcedBy create(ArchitecturalRequirement architecturalRequirement, double value) {
        return new ForcedBy(architecturalRequirement, value);
    }


}
