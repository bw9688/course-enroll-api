package com.fion.courseenrollapi.service.impl;

import com.fion.courseenrollapi.dao.CourseDao;
import com.fion.courseenrollapi.dto.res.GetCourseRes;
import com.fion.courseenrollapi.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public GetCourseRes getCourse() {
        GetCourseRes res = new GetCourseRes();
        res.setCourseList(courseDao.getCourseList());
        return res;
    }
}
