package ch.unisg.sat.core.domain.event;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SystemElementCreatedEvent extends ApplicationEvent {

    private final SystemClass systemClass;
    private final SystemElement systemElement;

    public SystemElementCreatedEvent(Object source, SystemClass systemClass, SystemElement systemElement) {
        super(source);
        this.systemClass = systemClass;
        this.systemElement = systemElement;
    }
}
