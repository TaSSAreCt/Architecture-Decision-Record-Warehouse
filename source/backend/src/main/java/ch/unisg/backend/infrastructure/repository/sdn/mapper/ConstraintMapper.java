package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.infrastructure.repository.sdn.node.ConstraintNode;

public class ConstraintMapper {

    public static Constraint toConstraint(ConstraintNode constraintNode) {
        return Constraint.create(constraintNode.getId(), constraintNode.getTitle());
    }
}
