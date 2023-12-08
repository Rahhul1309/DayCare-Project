package edu.neu.csye6200.service;
import edu.neu.csye6200.model.*;


public class StudentFactory extends PersonFactory<Student> {
        
    @Override
    public Student getObject(String csvData) {
        return new Student(csvData);
    }
    
    @Override
    public Student getObject() {
        // TODO Auto-generated method stub
        return new Student();
    }
}
