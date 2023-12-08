package edu.neu.csye6200.service;

import edu.neu.csye6200.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.neu.csye6200.repository.StudentRepository;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    StudentFactory sf = new StudentFactory();
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void saveStudents(List<Student> students){
        studentRepository.saveAll(students);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void saveStudent(String csv){
        studentRepository.save(sf.getObject(csv));
    }

    public Optional<Student> getStudentById(Integer id){
        return studentRepository.findById(id);
    }

    public boolean deleteStudentById(Integer id){
        studentRepository.deleteById(id);
        return false;
    }
    public void deleteStudents() {
        studentRepository.deleteAll();
    }

    public boolean updateStudent(Integer id, Student updatedStudent) {
        return false;
    }
}
