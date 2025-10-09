package ch.unisg.backend.infrastructure.repository.sdn;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.port.out.ConstraintPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.ConstraintCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.ConstraintNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ConstraintRepository implements ConstraintPort {

  private final ConstraintCypherPort repository;

  @Override
  public void create(Constraint constraint) {
    repository.save(ConstraintNode.create(constraint.getId(), constraint.getTitle(), constraint.isCyber()));
  }

  @Override
  public Constraint readById(UUID id) {

    Optional<ConstraintNode> entity = repository.findById(id);

    return entity
        .map(constraintNode -> Constraint.create(constraintNode.getId(), constraintNode.getTitle(),
            constraintNode.isCyber()))
        .orElse(null);
  }

  @Override
  public void readAll(List<Constraint> constraintList) {

    List<ConstraintNode> constraintNodeList = repository.findAll();

    for (ConstraintNode constraintNode : constraintNodeList) {
      constraintList
          .add(Constraint.create(constraintNode.getId(), constraintNode.getTitle(), constraintNode.isCyber()));
    }
  }
}
