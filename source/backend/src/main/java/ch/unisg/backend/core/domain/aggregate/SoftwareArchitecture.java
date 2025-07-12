package ch.unisg.backend.core.domain.aggregate;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SoftwareArchitecture {

    private final List<SystemOfSystems> systemsOfSystems;

    private SoftwareArchitecture() {
        this.systemsOfSystems = new ArrayList<>();
    }

    public static SoftwareArchitecture create() {
        return new SoftwareArchitecture();
    }
}
