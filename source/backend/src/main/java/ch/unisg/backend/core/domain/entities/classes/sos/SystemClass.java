package ch.unisg.backend.core.domain.entities.classes.sos;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class SystemClass extends MetaClass {

  private final boolean isCyber;
  private final List<SystemClass> systemList = new ArrayList<>();
  private final List<SystemElement> systemElementList = new ArrayList<>();
  private final List<NonFunctionalRequirement> nonFunctionalRequirementList = new ArrayList<>();
  private final List<Issue> issueList = new ArrayList<>();
  private final List<Rationale> rationaleList = new ArrayList<>();

  public SystemClass(UUID id, String title, boolean isCyber) {
    super(id, title);
    this.isCyber = isCyber;
  }

  public static SystemClass create(boolean isCyber) {
    return new SystemClass(null, null, true);
  }

  public static SystemClass create(UUID id, boolean isCyber) {
    return new SystemClass(id, null, isCyber);
  }

  public static SystemClass create(UUID id, String title, boolean isCyber) {
    return new SystemClass(id, title, isCyber);
  }

  public static SystemClass create(UUID id) {
    return new SystemClass(id, null, true);
  }

}
