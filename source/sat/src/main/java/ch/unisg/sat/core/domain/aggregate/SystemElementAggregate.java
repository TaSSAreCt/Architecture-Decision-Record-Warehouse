package ch.unisg.sat.core.domain.aggregate;

import ch.unisg.sat.core.domain.entities.classes.ar.Constraint;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SystemElementAggregate {

    @Setter
    private SystemElement systemElement;
    private final List<Constraint> constraintList = new ArrayList<>();

    private SystemElementAggregate() {
    }

    public static SystemElementAggregate create() {
        return new SystemElementAggregate();
    }

}
