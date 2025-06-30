package ch.unisg.sat.core.domain.entities.classes.ad;

import ch.unisg.sat.core.domain.entities.classes.MetaClass;
import ch.unisg.sat.core.domain.entities.classes.ar.ArchitectureRequirement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Getter @Setter
public class Alternative extends MetaClass {

    List<ArchitectureRequirement> architectureRequirements = new ArrayList<>();

    public int getValue() {

        AtomicInteger value = new AtomicInteger();

        this.architectureRequirements.forEach(architectureRequirement -> {
            value.addAndGet(architectureRequirement.getValue());
        });

        return value.intValue();
    }

    public Alternative() {}

    public Alternative(UUID id, String title) {
        super(id, title);
    }

    public Alternative(String title) { super(title); }
    public Alternative(UUID id) { super(id); }

    public static Alternative create() {
        return new Alternative();
    }
    public static Alternative create(UUID id) {
        return new Alternative(id);
    }
    public static Alternative create(UUID id, String title) {
        return new Alternative(id, title);
    }

}
