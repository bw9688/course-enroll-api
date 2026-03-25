package com.fion.courseenrollapi.service;

import com.fion.courseenrollapi.dao.CourseDao;
import com.fion.courseenrollapi.dto.res.GetCourseRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public GetCourseRes getCourse() {
        GetCourseRes res = new GetCourseRes();
        res.setCourseList(courseDao.getCourseList());
        return res;
    }
}
