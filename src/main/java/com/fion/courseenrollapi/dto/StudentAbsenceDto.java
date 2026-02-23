package com.fion.courseenrollapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class StudentAbsenceDto {
    private String studentId;
    private String studentName;
    private LocalDateTime attendTime;
    private Boolean attendanceStatus;
}
