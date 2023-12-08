package edu.neu.csye6200.util;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.service.*;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TestDataUtil {
    TeacherFactory tf = new TeacherFactory();
    static StudentFactory sf = new StudentFactory();
    VaccinationFactory vf = new VaccinationFactory();


    public List<Teacher> populateTeacherData(String csv){
        String currentDirectory = System.getProperty("user.dir");
        List<Teacher> teachers = new ArrayList<>();
        String filePath1 = currentDirectory + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "teachers.txt";
        List<String> teacherCsv = FileUtil.readCsv(filePath1);
        for(String teacherString : teacherCsv){
            teachers.add(tf.getObject(teacherString));
        }
        return teachers;
    }
    public static List<Student> populateStudentData(String csv){
        String currentDirectory = System.getProperty("user.dir");
        List<Student> students = new ArrayList<>();
        String filePath = currentDirectory + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "students.txt";
        List<String> studentCsvs = FileUtil.readCsv(filePath);
        for(String studentString : studentCsvs){
            students.add(sf.getObject(studentString));
        }
        return students;
    }
    public List<Immunization> populateVaccineData(String csv){
        List<Immunization> vaccines = new ArrayList<>();
        List<String> vaccineCsvs = FileUtil.readCsv(csv);
        for(String vaccineString : vaccineCsvs){
            vaccines.add(vf.getObject(vaccineString));
        }
        return vaccines;
    }
}
