package edu.neu.csye6200.service;
import edu.neu.csye6200.model.Person;


public abstract class PersonFactory<T extends Person> {
    public abstract T getObject(String csvData);
    public abstract T getObject();
}
