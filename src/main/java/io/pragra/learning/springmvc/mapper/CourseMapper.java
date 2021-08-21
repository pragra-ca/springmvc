package io.pragra.learning.springmvc.mapper;

import io.pragra.learning.springmvc.entity.Course;
import io.pragra.learning.springmvc.model.CourseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course courseDtoToCourse(CourseDto courseDto) {
        return Course.builder().name(courseDto.getName()).desc(courseDto.getDesc()).build();
    }

    public CourseDto courseToCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId().intValue());
        courseDto.setName(course.getName());
        courseDto.setDesc(course.getDesc());
        return courseDto;
    }
}
