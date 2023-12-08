package edu.neu.csye6200.service;
import edu.neu.csye6200.model.Immunization;


public class VaccinationFactory {
    public Immunization getObject(String csvData) {
        return new Immunization(csvData);
    }
}
