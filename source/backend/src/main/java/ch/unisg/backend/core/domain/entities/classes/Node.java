
package ch.unisg.backend.core.domain.entities.classes;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public abstract class Node {

  @Getter
  protected final UUID id;

  @Getter
  @Setter
  protected String title;

  protected Node(UUID id, String title) {
    this.id = id;
    this.title = title;
  }
}
