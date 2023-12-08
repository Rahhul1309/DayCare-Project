package edu.neu.csye6200.repository;

import edu.neu.csye6200.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface PersonRepository<T extends Person> extends CrudRepository<T, Integer> {
}
