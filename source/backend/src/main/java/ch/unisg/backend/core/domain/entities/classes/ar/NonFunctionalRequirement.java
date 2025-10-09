package ch.unisg.backend.core.domain.entities.classes.ar;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import lombok.Getter;

import java.util.UUID;

@Getter
public class NonFunctionalRequirement extends MetaClass implements ArchitectureRequirementType {

  private boolean isCyber;

  public NonFunctionalRequirement() {
  }

  public NonFunctionalRequirement(UUID id, String title) {
    super(id, title);
  }

  public NonFunctionalRequirement(UUID id, String title, boolean isCyber) {
    super(id, title);
    this.isCyber = isCyber;
  }

  public static NonFunctionalRequirement create(UUID id, String title) {
    return new NonFunctionalRequirement(id, title);
  }

  public static NonFunctionalRequirement create(UUID id) {
    return new NonFunctionalRequirement(id, "");
  }

  public static NonFunctionalRequirement create(UUID id, String title, boolean isCyber) {
    return new NonFunctionalRequirement(id, title, isCyber);
  }

}
