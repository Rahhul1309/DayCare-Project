package edu.neu.csye6200.repository;

import edu.neu.csye6200.model.Student;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends PersonRepository<Student> {
}
