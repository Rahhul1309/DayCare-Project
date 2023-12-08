package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.service.TeacherService;
import edu.neu.csye6200.util.TestDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/addTestData")
    public ResponseEntity<String> addTestData() {
        teacherService.saveTeachers(new TestDataUtil().populateTeacherData("Teachers.csv"));
        return ResponseEntity.ok("Test data added successfully");
    }

    @GetMapping("/getAllTeachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addTeacher")
    public ResponseEntity<String> addTeacher(@RequestBody String csv) {
        teacherService.saveTeacher(csv);
        return ResponseEntity.ok("Teacher added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTeacherById(@PathVariable Integer id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok("Teacher deleted successfully");
    }

    @DeleteMapping("/removeAllTeachers")
    public ResponseEntity<String> removeTeachers() {
        teacherService.deleteTeachers();
        return ResponseEntity.ok("All teachers deleted successfully");
    }
}
