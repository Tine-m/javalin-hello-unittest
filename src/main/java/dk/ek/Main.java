package dk.ek;

import dk.ek.controllers.HelloWithContextController;
import dk.ek.controllers.HelloWithServiceController;
import dk.ek.controllers.HelloWithoutContextController;
import dk.ek.persistence.InMemoryPersonRepository;
import dk.ek.persistence.PersonRepository;
import dk.ek.services.PersonService;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        PersonRepository repo = new InMemoryPersonRepository();
        PersonService service = new PersonService(repo);
        HelloWithContextController withContext = new HelloWithContextController(repo);
        HelloWithoutContextController withoutContext = new HelloWithoutContextController(repo);
        HelloWithServiceController withService = new HelloWithServiceController(service);

        Javalin app = Javalin.create().start(7070);

        withContext.addRoutes(app);
        withService.addRoutes(app);

        app.get("/hello-simple/{lastName}", ctx -> {
            String lastName = ctx.pathParam("lastName");
            ctx.result(withoutContext.hello(lastName));
        });
    }
}
