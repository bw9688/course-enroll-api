package com.fion.courseenrollapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttendanceDto {
    private String studentId;
    private String studentName;
    private LocalDateTime attendTime;
    private boolean attendance;
}
