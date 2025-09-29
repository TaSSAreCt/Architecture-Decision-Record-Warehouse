package ch.unisg.backend.core.port.in.command.relationships;

import ch.unisg.backend.core.port.in.command.classes.SystemCommand;
import lombok.NonNull;

public record PartOfCommand(
        @NonNull SystemCommand parentSystemClass,
        @NonNull SystemCommand childSystemClass
        ) {

    public PartOfCommand(SystemCommand parentSystemClass, SystemCommand childSystemClass) {
        this.parentSystemClass = parentSystemClass;
        this.childSystemClass = childSystemClass;
    }

    public static PartOfCommand create(SystemCommand parentSystemClass, SystemCommand childSystemClass) {
        return new PartOfCommand(parentSystemClass, childSystemClass);
    }
}
