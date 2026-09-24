package dk.ek.controllers;

import dk.ek.entities.Person;
import dk.ek.persistence.PersonRepository;
import dk.ek.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepo;

    private PersonService subject;

    @BeforeEach
    void setUp() {
        subject = new PersonService(personRepo);
    }

    @Test
    void shouldReturnFullNameOfAPerson() {

        Person peter = new Person("Peter", "Pan");

        given(personRepo.findByLastName("Pan"))
                .willReturn(Optional.of(peter));

        String greeting = subject.hello("Pan");

        assertEquals("Hello Peter Pan!", greeting);
    }

    @Test
    void shouldTellIfPersonIsUnknown() {

        given(personRepo.findByLastName(anyString()))
                .willReturn(Optional.empty());

        String greeting = subject.hello("Pan");

        assertEquals(
                "Who is this 'Pan' you're talking about?",
                greeting);
    }
}