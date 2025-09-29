package ch.unisg.backend.core.domain.aggregate;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArchitectureDecisionRecordWarehouse {

    private final List<SystemClass> systemsOfSystems = new ArrayList<>();

    private ArchitectureDecisionRecordWarehouse() {}

    public static ArchitectureDecisionRecordWarehouse create() {
        return new ArchitectureDecisionRecordWarehouse();
    }
}
