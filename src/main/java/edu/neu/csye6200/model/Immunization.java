package edu.neu.csye6200.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Immunization {
@Id
    private int personID;
    private String vaccine;
    private Date v1t1;
    private Date v1t2;
    private String vaccine2;
    private Date v2t1;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String readVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public Date getV1t1() {
        return v1t1;
    }

    public void setV1t1(Date v1t1) {
        this.v1t1 = v1t1;
    }

    public Date getV1t2() {
        return v1t2;
    }

    public void setV1t2(Date v1t2) {
        this.v1t2 = v1t2;
    }

    public String readVaccine2() {
        return vaccine2;
    }

    public void setVaccine2(String vaccine2) {
        this.vaccine2 = vaccine2;
    }

    public Date getV2t1() {
        return v2t1;
    }

    public void setV2t1(Date v2t1) {
        this.v2t1 = v2t1;
    }

    public Immunization(int personID, String vaccine, Date v1t1, Date v1t2, String vaccine2, Date v2t1) {
        this.personID = personID;
        this.vaccine = vaccine;
        this.v1t1 = v1t1;
        this.v1t2 = v1t2;
        this.vaccine2 = vaccine2;
        this.v2t1 = v2t1;
    }

    public Immunization() {
    }

    public Immunization(String csv){
    try {
            String[] field = csv.split(",");
            this.personID = Integer.parseInt(field[0]);
            this.vaccine = field[1];
            this.v1t1 = validDateString(field[2]);
            this.v1t2 = validDateString(field[3]);
            this.vaccine2 = field[4];
            this.v2t1 = validDateString(field[5]);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public Date validDateString(String date) {
        if (date.equals(" ") || date == null || date.isEmpty()) {
            return null;
        } else {
            try {
                return new SimpleDateFormat("MM/dd/yyyy").parse(date);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
