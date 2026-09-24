package dk.ek.controllers;

import dk.ek.entities.Person;
import dk.ek.persistence.PersonRepository;
import io.javalin.http.Context;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HelloWithContextControllerTest {
    @Mock
    private PersonRepository personRepo;

    @Mock
    private Context ctx;

    @Test
    void shouldReturnFullNameOfAPerson() {
        Person peter = new Person("Peter", "Pan");
        given(ctx.pathParam("lastName")).willReturn("Pan");
        given(personRepo.findByLastName("Pan")).willReturn(Optional.of(peter));

        HelloWithContextController subject = new HelloWithContextController(personRepo);
        subject.hello(ctx);

        verify(ctx).result("Hello Peter Pan!");
    }

    @Test
    void shouldTellIfPersonIsUnknown() {
        given(ctx.pathParam("lastName")).willReturn("Hook");
        given(personRepo.findByLastName("Hook")).willReturn(Optional.empty());

        HelloWithContextController subject = new HelloWithContextController(personRepo);
        subject.hello(ctx);

        verify(ctx).result("Who is this 'Hook' you're talking about?");
    }
}
