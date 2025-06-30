package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.entities.classes.ar.Constraint;
import ch.unisg.sat.core.port.in.ConstraintUseCase;
import ch.unisg.sat.core.port.in.command.classes.ConstraintCommand;
import ch.unisg.sat.core.port.in.query.classes.ConstraintQuery;
import ch.unisg.sat.core.port.out.ConstraintPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConstraintService implements ConstraintUseCase {

    private final ConstraintPort constraintPort;

    @Override
    public void create(ConstraintCommand command) {
        Constraint constraint = Constraint.create(command.id(), command.title());
        constraintPort.create(constraint);
    }

    @Override
    public Constraint findById(ConstraintQuery query) {

        Constraint constraint = Constraint.create(query.id());
        return constraintPort.readById(constraint);
    }

}
