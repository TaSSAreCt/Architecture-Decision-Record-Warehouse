package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.domain.entities.relationships.SolvedBy;
import ch.unisg.backend.core.port.in.AlternativeUseCase;
import ch.unisg.backend.core.port.in.command.CreateAlternativeWithIssueCommand;
import ch.unisg.backend.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.backend.core.port.in.query.AlternativeQuery;
import ch.unisg.backend.core.port.out.AlternativePort;
import ch.unisg.backend.core.port.out.RelationshipManagerPort;
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
