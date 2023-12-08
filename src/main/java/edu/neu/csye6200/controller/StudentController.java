package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.service.StudentService;
import edu.neu.csye6200.util.FileUtil;
import edu.neu.csye6200.util.TestDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create: Add a new student
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student added successfully");
    }

    @PostMapping("/UploadCsv")
    public ResponseEntity<String> UploadStudentCsv(@RequestParam("file") MultipartFile file){
        List<Student> Students = TestDataUtil.populateStudentData(String.valueOf(file));
        studentService.saveStudents(Students);
        return ResponseEntity.ok("Student added successfully from Csv");

    }

    // Read: Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Read: Get a specific student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update: Update a specific student by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        if (studentService.updateStudent(id, updatedStudent)) {
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete: Delete a specific student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
        if (studentService.deleteStudentById(id)) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
