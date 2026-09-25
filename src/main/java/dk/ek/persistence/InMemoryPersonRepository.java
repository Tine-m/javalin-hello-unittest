package dk.ek.persistence;

import dk.ek.entities.Person;

import java.util.List;
import java.util.Optional;

public class InMemoryPersonRepository implements PersonRepository {
    private final List<Person> persons = List.of(
            new Person("Peter", "Pan"),
            new Person("Wendy", "Darling")
    );

    @Override
    public Optional<Person> findByLastName(String lastName) {
        return persons.stream()
                .filter(p -> p.getLastName().equalsIgnoreCase(lastName))
                .findFirst();
    }
}
