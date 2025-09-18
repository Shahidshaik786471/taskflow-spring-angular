# TaskFlow (Spring Boot + Angular + PostgreSQL)

**Stack:** Spring Boot 3, JPA/Hibernate, PostgreSQL, Angular (Vite), Docker, Jenkins

## Run with Docker
```bash
docker compose up --build
```
- Backend: http://localhost:8080 (Swagger UI at `/swagger-ui/index.html`)
- Frontend: http://localhost:5173

## Local Dev
1. Start PostgreSQL (or use Docker service `db`)
2. Backend:
   ```bash
   cd backend
   ./mvnw spring-boot:run # or mvn spring-boot:run
   ```
3. Frontend:
   ```bash
   cd frontend-angular
   npm i
   npm run start
   ```

## Features
- CRUD Tasks (title, assignee, status)
- RESTful APIs (`/api/tasks`)
- Simple Angular UI

## CI/CD
- Jenkinsfile builds, tests, and dockerizes the backend
