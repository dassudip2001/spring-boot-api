# Get all application routes

```bash
- [GET] localhost:8080/api/v1/applications
- [GET] localhost:8080/api/v1/applications/{id}
- [POST] localhost:8080/api/v1/applications
- [PUT] localhost:8080/api/v1/applications/{id}
- [DELETE] localhost:8080/api/v1/applications/{id}
```

- Build and Run

```bash
# Build
mvn clean install

# Run
java -jar target/assignment-0.0.1-SNAPSHOT.jar
```

- Run with Docker

```bash
# Build
docker build -t assignment .

# Run
docker run -p 8080:8080 assignment
```
