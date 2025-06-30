package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.port.in.command.CreateAlternativeWithIssueCommand;
import ch.unisg.sat.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.sat.core.port.in.query.classes.AlternativeQuery;


public interface AlternativeUseCase {
    void create(CreateAlternativeWithIssueCommand command);
    void createAlternative(AlternativeCommand command);
    Alternative findAlternativeById(AlternativeQuery query);
}
