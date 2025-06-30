package ch.unisg.sat.controller.http.dto.response.cpsos;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemClassList;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SystemClassListResponseDto {

    private final List<SystemClassResponseDto> systemClassList;

    private SystemClassListResponseDto() {
        this.systemClassList = new ArrayList<>();
    }

    public static ArrayList<Object> toJson(SystemClassList systemClassList) {

        ArrayList<Object> dto = new ArrayList<>();

        for (SystemClass element : systemClassList.getSystemClassList()) {
            dto.add(SystemClassResponseDto.toJson(element.getId(), element.getTitle()));
        }

        return dto;
    }

}
