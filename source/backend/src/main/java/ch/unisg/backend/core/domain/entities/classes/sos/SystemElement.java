package ch.unisg.backend.core.domain.entities.classes.sos;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class SystemElement extends MetaClass {

  private final List<Constraint> constraintList = new ArrayList<>();
  private final boolean isCyber;

  public SystemElement() {
    this.isCyber = true;
  }

  public SystemElement(UUID id) {
    super(id);
    this.isCyber = true;
  }

  public SystemElement(UUID id, String title) {
    super(id, title);
    this.isCyber = true;
  }

  public SystemElement(UUID id, String title, boolean isCyber) {
    super(id, title);
    this.isCyber = isCyber;
  }

  public static SystemElement create() {
    return new SystemElement();
  }

  public static SystemElement create(UUID id) {
    return new SystemElement(id);
  }

  public static SystemElement create(UUID id, String title, boolean isCyber) {
    return new SystemElement(id, title, isCyber);
  }
}
