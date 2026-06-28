## Project overview

## Tech stack

- **Language**: Java 25
- **Framework**: Spring Boot 4.1.0
- **Build Tool**: Apache Maven 3.9.16

## Interfaces

- `docs/openapi.yaml`: the HTTP interface definition

## Test cases

- `docs/projects.feature`: test cases

## Rules

- Never change tests while refactoring sources.
- Avoid Primitive Obsession code smell; always use value objects instead.
- Use JUnit 5 tags to group tests into test suites.
- Never share state between tests.
- Make sure the test tests one thing only
- Use the Object Monther Pattern to create complex objects for unit tests
- Test names must describe WHAT, not HOW and should read as 'I'd like to @Test WHAT' e.g. @Test void currentAccountOpening
- Use Mockito to substitute dependencies. Use @Captor with verifications.
- Annotate component tests with @ComponentTest.
- Application is available on local.server.host and local.server.port.
- Avoid @DirtiesContext.
- Use Spring WebTestClient for HTTP requests.
- Prefer deep equals comparisons whenever possible rather than individual fields.
- Prefer Spring WebTestClient built-in assertions to AssertJ.

## Commands

- Run unit tests: `./mvnw test -Dgroups=unit`
- Run component tests: `./mvnw test -Dgroups=component`

## Code style

- `java-code-style.md`: the Java code style.

## Pull Request instructions

- Follow the [Chris Beams](http://chris.beams.io/posts/git-commit) style for commit messages.
