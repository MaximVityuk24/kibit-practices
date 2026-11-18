
# Практична робота № 3 — CRUD API та Swagger

## Опис проєкту

Вебсервіс credit на Spring Boot для роботи з картками.
Реалізовано повний CRUD API та документацію Swagger UI.

## Використані технології

- Java 17
- Spring Boot 3.5.16
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger UI)
- Maven

## Реалізовані API

- POST /api/create — створення картки
- GET /api/retrieve/{cardId} — отримання картки
- PUT /api/update/{cardId} — оновлення картки
- DELETE /api/delete/{cardId} — видалення картки

## Запуск

Зібрати проєкт:

mvn clean package

Запустити застосунок:

java -jar target/credit-0.0.3-SNAPSHOT.jar

Сервер працює на порту 8082.

## Документація Swagger

http://localhost:8082/swagger-ui/index.html

## Результат

Реалізовано та перевірено всі чотири операції CRUD.
Дані карток зберігаються в базі даних H2.
API протестовано через Swagger UI.
