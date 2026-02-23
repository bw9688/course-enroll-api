package com.fion.courseenrollapi.dto.res;

import com.fion.courseenrollapi.dto.StudentAbsenceDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetStudentAbsenceRes {
    private List<StudentAbsenceDto> studentAbsenceDtoList;
}