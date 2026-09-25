package dk.ek.persistence;

import dk.ek.entities.Person;

import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findByLastName(String lastName);
}
