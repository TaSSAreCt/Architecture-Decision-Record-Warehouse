package ch.unisg.sat.core.port.in.command.classes;

import java.util.UUID;

public record ArchitectureRationaleCommand(
        UUID id,
        String title,
        String context,
        String decision,
        String status,
        String consequences
) {

    public ArchitectureRationaleCommand(
            UUID id,
            String title,
            String context,
            String decision,
            String status,
            String consequences
    ) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.decision = decision;
        this.status = status;
        this.consequences = consequences;
    }

    public static ArchitectureRationaleCommand create(
            UUID id,
            String title,
            String context,
            String decision,
            String status,
            String consequences
    ) {
        return new ArchitectureRationaleCommand(id, title, context, decision, status, consequences);
    }

    public static ArchitectureRationaleCommand create(UUID id) {return new ArchitectureRationaleCommand(id, null, null, null, null, null);}

}
