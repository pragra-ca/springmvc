package io.pragra.learning.springmvc.controller.rest;

import io.pragra.learning.springmvc.apis.CourseApi;
import io.pragra.learning.springmvc.entity.Course;
import io.pragra.learning.springmvc.mapper.CourseMapper;
import io.pragra.learning.springmvc.model.CourseDto;
import io.pragra.learning.springmvc.repo.CourseRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseRestController implements CourseApi {
    private CourseRepo repo;
    private CourseMapper mapper;

    public CourseRestController(CourseRepo repo, CourseMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<CourseDto> addCourse(CourseDto body) {
        Course course = mapper.courseDtoToCourse(body);
        return ResponseEntity.accepted().body(mapper.courseToCourseDto(repo.save(course)));
    }

    @Override
    public ResponseEntity<List<CourseDto>> courseGet() {
        List<CourseDto> dtos = repo.findAll().stream().map(mapper::courseToCourseDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<CourseDto> getCourseById(Long courseId) {
        return null;
    }
}
