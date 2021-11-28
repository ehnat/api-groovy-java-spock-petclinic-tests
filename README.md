### Project description

The project contains API tests for a few scenarios for Petclinic application.

Tested scenarios:

A. basic, short tests:

1) owners: get all, get proper one, add new owner
2) visits: get all, get proper one, add new visit
3) vets: get all, get proper one
4) pets: get all, add new pet
5) pet types: get proper one

B. advanced, longer test:

6) a new visit is scheduled for a new owner and his pet

### Technical description

- Used technologies: Groovy 2.5, Java 8, Gradle
- Used frameworks/libraries: RestAssured, Spock 2.0, AssertJ
- Test reports: Gradle, Spock

### How to run application under test:

Running the application under test is the entry point for tests.

Repository for Petclinic application:
`https://github.com/spring-petclinic/spring-petclinic-rest`.

There is detailed information how to configure and run application.

Below I put a shortcut how to run Petclinic:

- `git clone https://github.com/spring-petclinic/spring-petclinic-rest.git`
- `cd spring-petclinic-rest`
- `./mvnw spring-boot:run`

### Documentation:

When application is run api documentation can be found here:
`http://localhost:9966/petclinic/swagger-ui.html`

### Postman collection:

Folder `postman` - there is a postman collection which I created to support myself with manual checking api requests.

### Test reports:

- Gradle: `build/reports/tests/test/index.html`
- Spock: `build/spock-reports/index.html`

### Repeating failed tests:

For repeating failure tests I use `spock-retry` dependency (set by annotation `@RetryOnFailure` in `BaseSpec.groovy`).
Repo for dependency: https://mvnrepository.com/artifact/com.anotherchrisberry/spock-retry

### Test configurations (environments and categories):

A. environment

- now only one environment is used (`default`)
- environment can be set from command line by using `-Denv=ENVIRONMENT`
  where `ENVIRONMENT`: `default`.

B. categories Tests are divided by categories.

- category can be set from command line by using `-DtestGroups=TESTS_GROUPS`
  where `TESTS_GROUPS`: `regression`, `smoke`.

C. default test configuration

- default test configuration is set in `build.gradle`, `DEFAULT_ENVIRONMENT_TEST_GROUPS`.

### How to run tests

1) mac
   `./gradlew clean test -Denv=ENVIRONMENT -DtestGroups=TEST_GROUPS --info --continue`

2) windows
   `gradlew.bat clean test -Denv=ENVIRONMENT -DtestGroups=TEST_GROUPS --info --continue`

### Samples of use in testing other solutions

a) example of using `Groovy Object Creation with Tap Method`:

- used in: `VisitCreator.groovy`
- documentation: https://blog.mrhaki.com/2018/06/groovy-goodness-easy-object-creation.html

b) example of using `Custom Assertions` from AssertJ:

- used in: `assertions` package, `PetSpec.groovy`, `VetSpec.groovy`
- documentation:
  `https://assertj.github.io/doc/#assertj-core-custom-assertions`,
  `https://joel-costigliola.github.io/assertj/assertj-core-custom-assertions.html`

### Static code analysis with codenarc

To have the same rules while adding code the static analysis tool for Groovy (Codenarc https://codenarc.org/) was added
to the project (integrated via Gradle plugin). The files with rules are defined in `config/codenarc` dir at the project
root.

To run static analysis for the whole project the following command needs to be invoked:

- mac: `./gradlew codenarcMain codenarcTest --info --continue`
- windows: `gradlew.bat codenarcMain codenarcTest --info --continue`

Reports what needs to be fixed is available in html report generated at the end here: `build/reports/codenarc`

### Other branches:

- `main` - tests using Spock 1.3
- `spock_2_0` - the same tests which are in `main` branch using Spock 2.0