# Javalin hello test

Mini Maven-projekt til at sammenligne flere måder at skrive og unit-teste `hello` på:

1. `hello(String lastName)` uden Javalin `Context`.
2. `hello(Context ctx)` som en rigtig Javalin handler.

## Kør

Åbn mappen som Maven-projekt i IntelliJ og kør `Main`.

- `http://localhost:7070/hello-simple/Pan`
- `http://localhost:7070/hello-context/Pan`
- `http://localhost:7070/hello-service/Pan`
- Prøv også fx `Hook` som efternavn.

Kør derefter testklasserne under `src/test/java` og sammenlign dem.
