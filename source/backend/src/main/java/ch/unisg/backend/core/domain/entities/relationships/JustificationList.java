package ch.unisg.backend.core.domain.entities.relationships;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class JustificationList extends RelationshipClass {

    private List<Justification> justificationList;

    public JustificationList() {
        this.justificationList = new ArrayList<>();
    }

    public void add(Justification j) {
        if (j != null) {
            this.justificationList.add(j);
        }
    }

    public void remove(Justification j) {
        this.justificationList.remove(j);
    }

}
