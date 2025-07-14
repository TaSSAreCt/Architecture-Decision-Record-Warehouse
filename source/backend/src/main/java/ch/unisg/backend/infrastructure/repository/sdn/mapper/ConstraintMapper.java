package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.infrastructure.repository.sdn.node.ConstraintNode;

import java.util.List;
import java.util.Set;

public class ConstraintMapper {

    public static Constraint toConstraint(ConstraintNode constraintNode) {
        return Constraint.create(constraintNode.getId(), constraintNode.getTitle());
    }

    public static List<Constraint> toConstraintList(List<ConstraintNode> constraintNodeList) {
        return constraintNodeList.stream().map(ConstraintMapper::toConstraint).toList();
    }
}
