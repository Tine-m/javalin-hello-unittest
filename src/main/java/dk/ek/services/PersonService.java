package dk.ek.services;

import dk.ek.entities.Person;
import dk.ek.persistence.PersonRepository;

import java.util.Optional;

public class PersonService {

    private final PersonRepository personRepo;

    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    public String hello(String lastName) {

        Optional<Person> foundPerson =
                personRepo.findByLastName(lastName);

        return foundPerson
                .map(person -> String.format(
                        "Hello %s %s!",
                        person.getFirstName(),
                        person.getLastName()))
                .orElse(String.format(
                        "Who is this '%s' you're talking about?",
                        lastName));
    }
}
