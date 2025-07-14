package ch.unisg.backend.controller.http.dto.response.cpsos;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SystemClassListResponseDto {

    private final List<SystemClassResponseDto> systemClassList;

    private SystemClassListResponseDto() {
        this.systemClassList = new ArrayList<>();
    }

    public static ArrayList<Object> toJson(List<SystemClass> systemClassList) {

        ArrayList<Object> dto = new ArrayList<>();

        for (SystemClass element : systemClassList) {
            dto.add(SystemClassResponseDto.toJson(element));
        }

        return dto;
    }

}
