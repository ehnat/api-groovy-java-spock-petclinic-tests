### Project description:
TBD

### How to run app:
`https://github.com/spring-petclinic/spring-petclinic-rest`

- `git clone https://github.com/spring-petclinic/spring-petclinic-rest.git`
- `cd spring-petclinic-rest`
- `./mvnw spring-boot:run`

### Documentation:
`http://localhost:9966/petclinic/swagger-ui.html`

### Postman collection:
In folder `postman` there is postman collection used during creating tests

### Test reports:
- Gradle: `build/reports/tests/test/index.html`
- Spock: `build/spock-reports/index.html`

### Repeating failed tests:
- failure tests are repeated (`spock-retry` dependency, set by annotation `@RetryOnFailure`)
- `spock-retry` dependency repo: https://mvnrepository.com/artifact/com.anotherchrisberry/spock-retry