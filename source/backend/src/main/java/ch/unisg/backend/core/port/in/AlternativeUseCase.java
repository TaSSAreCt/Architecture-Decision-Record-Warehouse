package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.port.in.command.CreateAlternativeWithIssueCommand;
import ch.unisg.backend.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.backend.core.port.in.query.classes.AlternativeQuery;


public interface AlternativeUseCase {
    void create(CreateAlternativeWithIssueCommand command);
    void createAlternative(AlternativeCommand command);
    Alternative findAlternativeById(AlternativeQuery query);
}
