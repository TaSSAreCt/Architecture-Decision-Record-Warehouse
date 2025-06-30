package ch.unisg.sat.infrastructure.repository.mapper.ar;

import ch.unisg.sat.core.domain.entities.classes.ar.Constraint;
import ch.unisg.sat.infrastructure.repository.sdn.node.ConstraintNode;

public class ConstraintMapper {

    public static Constraint toConstraint(ConstraintNode constraintNode) {
        return Constraint.create(constraintNode.getId(), constraintNode.getTitle());
    }
}
