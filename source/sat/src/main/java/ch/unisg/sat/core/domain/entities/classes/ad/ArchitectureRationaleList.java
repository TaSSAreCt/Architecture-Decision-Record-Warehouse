package ch.unisg.sat.core.domain.entities.classes.ad;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ArchitectureRationaleList {

    @Setter @Getter
    private List<ArchitectureRationale> architectureRationales;


    public ArchitectureRationaleList() {
        this.architectureRationales = new ArrayList<>();
    }

    public static ArchitectureRationaleList create() {
        return new ArchitectureRationaleList();
    }

    public void add(ArchitectureRationale r) {
        if (r != null) {
            this.architectureRationales.add(r);
        }
    }

    public void remove(ArchitectureRationale r) {
        if (r != null) {
            this.architectureRationales.remove(r);
        }
    }
}
