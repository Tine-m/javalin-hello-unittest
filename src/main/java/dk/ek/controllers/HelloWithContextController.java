package dk.ek.controllers;

import dk.ek.entities.Person;
import dk.ek.persistence.PersonRepository;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.Optional;

public class HelloWithContextController {
    private final PersonRepository personRepo;

    public HelloWithContextController(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    public void addRoutes(Javalin app) {
        app.get("/hello-context/{lastName}", this::hello);
    }

    public void hello(Context ctx) {
        String lastName = ctx.pathParam("lastName");
        Optional<Person> foundPerson = personRepo.findByLastName(lastName);

        String greeting = foundPerson
                .map(person -> String.format("Hello %s %s!",
                        person.getFirstName(), person.getLastName()))
                .orElse(String.format("Who is this '%s' you're talking about?", lastName));

        ctx.result(greeting);
    }
}
