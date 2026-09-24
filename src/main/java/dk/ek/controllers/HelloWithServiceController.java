package dk.ek.controllers;

import dk.ek.services.PersonService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class HelloWithServiceController {

    private final PersonService personService;

    public HelloWithServiceController(PersonService personService) {
        this.personService = personService;
    }

    public void addRoutes(Javalin app) {
        app.get("/hello-service/{lastName}", this::hello);
    }

    public void hello(Context ctx) {
        String lastName = ctx.pathParam("lastName");

        String greeting = personService.hello(lastName);

        ctx.result(greeting);
    }
}