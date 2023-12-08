package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ClassRoom {

    private int classId;
    private int min_age;
    private int max_age;

    private int groupSize;
    private int maxGroups;
    private List<Integer> studentIdList;
    private List<Integer> teacherIdList;

    public ClassRoom(int classId, int min_age, int max_age, int groupsize, int maxGroups) {
        this.classId = classId;
        this.min_age = min_age;
        this.max_age = max_age;
        this.groupSize = groupsize;
        this.maxGroups = maxGroups;
        this.studentIdList = new ArrayList<Integer>();
        this.teacherIdList = new ArrayList<Integer>();
    }

    public void addStudentId(Integer id) {
        studentIdList.add(id);
    }

    public void addTeacherId(Integer id) {
        teacherIdList.add(id);
    }

    public void deleteStudentId(Integer id) {
        studentIdList.remove(id);
    }

    public void deleteTeacherId(Integer id) {
        teacherIdList.remove(id);
    }

    public int getClassId() {
        return classId;
    }

    public int getMin_age() {
        return min_age;
    }

    public int getMax_age() {
        return max_age;
    }

    public int getGroupsize() {
        return groupSize;
    }

    public int getMaxGroups() {
        return maxGroups;
    }

    public List<Integer> getStudentIdList() {
        return studentIdList;
    }

    public List<Integer> getTeacherIdList() {
        return teacherIdList;
    }

    @Override
    public String toString() {
        return "Student List :: " + Arrays.toString(this.studentIdList.toArray()) + "/n"
                + "Teachers List :: " + Arrays.toString(this.teacherIdList.toArray()) + "/n"
                + "S/T Ratio :: " + this.studentIdList.size() / this.teacherIdList.size() + "/n"
                + "Max Allowed Groups :: " + this.getMaxGroups() + "\n"
                + "Group Size :: " + this.getGroupsize() + "\n"
                + "Age Group :: " + this.min_age + "-" + this.max_age; //To change body of generated methods, choose Tools | Templates.
    }

}
