package ch.unisg.backend.core.application;

import ch.unisg.backend.core.port.in.InfluenceUseCase;
import ch.unisg.backend.core.port.out.InfluencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InfluenceService implements InfluenceUseCase {

    private final InfluencePort influencePort;

}
