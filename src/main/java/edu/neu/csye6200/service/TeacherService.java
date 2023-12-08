package edu.neu.csye6200.service;

import edu.neu.csye6200.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import edu.neu.csye6200.repository.TeacherRepository;


@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    TeacherFactory tf = new TeacherFactory();

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    public void saveTeachers(List<Teacher> teachers) {
        teacherRepository.saveAll(teachers);
    }

    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void saveTeacher(String csv) {
        teacherRepository.save(tf.getObject(csv));
    }

    public Optional<Teacher> getTeacherById(Integer id) {
        return teacherRepository.findById(id);
    }

    public void deleteTeacherById(Integer id) {
        teacherRepository.deleteById(id);
    }

    public void deleteTeachers() {
        teacherRepository.deleteAll();
    }
}
