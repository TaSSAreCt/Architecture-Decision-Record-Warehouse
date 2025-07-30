package ch.unisg.backend.core.domain.entities.classes.sos;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class SystemClass extends MetaClass {

    private final List<SystemClass> systemList = new ArrayList<>();
    private final List<SystemElement> systemElementList = new ArrayList<>();
    private final List<NonFunctionalRequirement> nonFunctionalRequirementList = new ArrayList<>();
    private final List<Issue> issueList = new ArrayList<>();
    private final List<Rationale> rationaleList = new ArrayList<>();

    public SystemClass(UUID id, String title) {
        super(id, title);
    }

    public static SystemClass create() {
        return new SystemClass(null, null);
    }
    public static SystemClass create(UUID id) {
        return new SystemClass(id, null);
    }
    public static SystemClass create(UUID id, String title) {
        return new SystemClass(id, title);
    }

}
