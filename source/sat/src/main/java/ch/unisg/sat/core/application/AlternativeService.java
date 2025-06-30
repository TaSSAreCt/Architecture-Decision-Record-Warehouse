package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ad.Issue;
import ch.unisg.sat.core.domain.entities.relationships.SolvedBy;
import ch.unisg.sat.core.port.in.AlternativeUseCase;
import ch.unisg.sat.core.port.in.command.CreateAlternativeWithIssueCommand;
import ch.unisg.sat.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.sat.core.port.in.query.classes.AlternativeQuery;
import ch.unisg.sat.core.port.out.AlternativePort;
import ch.unisg.sat.core.port.out.RelationshipManagerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlternativeService implements AlternativeUseCase {

    private final AlternativePort alternativePort;
    private final RelationshipManagerPort relationshipManagerPort;

    @Override
    public void create(CreateAlternativeWithIssueCommand command) {

        Alternative alternative = Alternative.create(command.id(), command.title());
        alternativePort.createAlternative(alternative);
        relationshipManagerPort.create(SolvedBy.create(alternative, Issue.create(command.issueId())));
    }

    @Override
    public void createAlternative(AlternativeCommand command) {

        Alternative alternative = new Alternative(command.id(), command.title());

        alternativePort.createAlternative(alternative);
    }

    @Override
    public Alternative findAlternativeById(AlternativeQuery query) {

        Alternative alternative = new Alternative(query.id());

        return alternativePort.readAlternativeById(alternative);
    }
}
