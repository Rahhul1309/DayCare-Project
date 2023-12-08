package edu.neu.csye6200.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;



@Entity
public class Student extends Person {

    private int grade;
    private Date registrationDate;
    private String address;
    private String phoneNumber;
    private String parentName;
    private String parentEmail;


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public Student() {
    }

    public Student(int age, String name, int grade, Date registrationDate, String address, String phoneNumber, String parentName, String parentEmail) {
        super(age, name);
        this.grade = grade;
        this.registrationDate = registrationDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
    }

    public Student(int id, int age, String name, int grade, Date registrationDate, String address, String phoneNumber, String parentName, String parentEmail) {
        super(id, age, name);
        this.grade = grade;
        this.registrationDate = registrationDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", registrationDate=" + registrationDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentEmail='" + parentEmail + '\'' +
                "} " + super.toString();
    }

    public Student(String csvData) {
        super();
        try {
            String[] field = csvData.split(",");
            this.setId(Integer.parseInt(field[0]));
            this.setName(field[1]);
            this.setAge(Integer.parseInt(field[2]));
            this.setGrade(Integer.parseInt(field[3]));
            //TODO: support time here tooo.
            this.registrationDate = new SimpleDateFormat("MM/dd/yyyy").parse(field[4]);
            this.parentName = field[5];
            //this.motherName = field[6];
            this.address = field[6];
            this.phoneNumber = field[7];
            this.parentEmail = field[8];
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
