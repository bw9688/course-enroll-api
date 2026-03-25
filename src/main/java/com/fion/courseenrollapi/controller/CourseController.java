package com.fion.courseenrollapi.controller;

import com.fion.courseenrollapi.dto.res.GetCourseRes;
import com.fion.courseenrollapi.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RestController
@RequestMapping("/api/student/class")
class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public ResponseEntity<GetCourseRes> getCourse() {
        GetCourseRes res = courseService.getCourse();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
