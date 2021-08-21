package io.pragra.learning.springmvc.repo;

import io.pragra.learning.springmvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    @Query("select s from Student s where s.lastName = :lastName or s.firstName = :lastName")
    List<Student> findAllByLastNameOrFirstName(@Param("lastName") String lastName);
}
