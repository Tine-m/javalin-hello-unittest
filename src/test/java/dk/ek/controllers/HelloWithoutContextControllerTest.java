package dk.ek.controllers;

import dk.ek.entities.Person;
import dk.ek.persistence.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class HelloWithoutContextControllerTest {
    @Mock
    private PersonRepository personRepo;

    @Test
    void shouldReturnFullNameOfAPerson() {
        Person peter = new Person("Peter", "Pan");
        given(personRepo.findByLastName("Pan")).willReturn(Optional.of(peter));

        HelloWithoutContextController subject = new HelloWithoutContextController(personRepo);
        String greeting = subject.hello("Pan");

        assertEquals("Hello Peter Pan!", greeting);
    }

    @Test
    void shouldTellIfPersonIsUnknown() {
        given(personRepo.findByLastName(anyString())).willReturn(Optional.empty());

        HelloWithoutContextController subject = new HelloWithoutContextController(personRepo);
        String greeting = subject.hello("Hook");

        assertEquals("Who is this 'Hook' you're talking about?", greeting);
    }
}
