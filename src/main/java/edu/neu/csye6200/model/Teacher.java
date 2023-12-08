package edu.neu.csye6200.model;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {
    private int credits;

    public Teacher() {
    }

    public Teacher(int age, String name, int credits) {
        super(age, name);
        this.credits = credits;
    }

    public Teacher(int id, int age, String name, int credits) {
        super(id, age, name);
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Teacher(String csvData)
    {
        super();
        try {
            String[] field = csvData.split(",");
            this.setId(Integer.parseInt(field[0]));
            this.setName(field[1]);
            this.setAge(Integer.parseInt(field[2]));
            this.setCredits(Integer.parseInt(field[3]));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "credits=" + credits +
                "} " + super.toString();
    }
}
