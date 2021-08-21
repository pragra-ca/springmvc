package io.pragra.learning.springmvc.service;

import io.pragra.learning.springmvc.entity.Course;
import io.pragra.learning.springmvc.entity.Student;
import io.pragra.learning.springmvc.exceptions.StudentNotFoundException;
import io.pragra.learning.springmvc.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo repo;

    public List<Student> getAll(){
        return repo.findAll();
    }

    public Student createStudent(Student student){
        return repo.save(student);
    }

    public Student enrollCourse(Long studentId, Course course) {
        Optional<Student> studentOptional = repo.findById(studentId);
        if (studentOptional.isPresent()) {
            studentOptional.get().getEnrolledCourses().add(course);
            return repo.save(studentOptional.get());
        }
        return null;
    }

    public void delete(Long id){
         repo.deleteById(id);
    }

    public Optional<Student> findById(Long id) {
        if(!repo.findById(id).isPresent())
            throw new StudentNotFoundException("No student could be located for id"+ id);
        return repo.findById(id);
    }

    public List<Student> findByLastName(String lastName) {
        return repo.findAllByLastNameOrFirstName(lastName);
    }
}
