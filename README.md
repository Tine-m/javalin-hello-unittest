# Unit test af Javalin Controller

Projektet sammenligner flere måder at unit-teste `hello` på:

1. `hello(String lastName)` i klassen `HelloWithoutContextController` - Javalin Controller klasse uden `Context`.
2. `hello(Context ctx)` i klassen `HelloWithContextController` - en Javalin handler, som I kender dem.
3. `hello(Context ctx)` i klassen `HelloWithServiceController`, hvor logikken er flyttet fra controller til en service klasse `PersonService`. Denne løsning er designmæssigt pænest. Men de andre eksempler illustrer en pointen om at unit test kan bruges i flere lag af applikationen.

## Kør

Åbn mappen som Maven-projekt i IntelliJ og kør `Main`.

- `http://localhost:7070/hello-simple/Pan`
- `http://localhost:7070/hello-context/Pan`
- `http://localhost:7070/hello-service/Pan`
- Prøv også fx `Hook` som efternavn.

Kør derefter testklasserne under `src/test/java` og sammenlign dem.
