package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.SystemRequestDto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreatePartOfRelationshipRequestDto {
    public final static String MEDIA_TYPE = "application/part-of+json";

    private UUID parentId;
    private UUID childId;
}