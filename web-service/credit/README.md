# Практична робота № 2 — Create API (Spring Boot)

Готовий навчальний проєкт **credit**: створення картки через `POST /api/create` збереженням до бази даних H2.

> Увага: початкові проєкти `account` та `credit` з навчального курсу не були надані. Це самостійний варіант за вимогами завдання; для повного збігу пакетів, назв методів і типу БД із викладацьким прикладом треба порівняти з проєктом `account`.

## Вимоги

- **JDK 17 або новіша**.
- **Maven 3.9+**, або вбудований Maven в IntelliJ IDEA.
- Інтернет для першого завантаження Maven-залежностей.

## Запуск у IntelliJ IDEA

1. Відкрийте папку `credit` як Maven-проєкт (має завантажитися `pom.xml`).
2. Дочекайтеся завантаження залежностей Maven.
3. У `src/main/java/ua/edu/kibit/credit/CreditApplication.java` запустіть метод `main`.
4. У консолі має з'явитися повідомлення на зразок `Tomcat started on port 8082`.

З термінала з папки `credit`:

```bash
mvn clean package
java -jar target/credit-0.0.1-SNAPSHOT.jar
```

`mvn clean package` також виконує тест, що перевіряє код 201, JSON-відповідь і збереження запису.

## Тестування POST API

**Linux, macOS або Git Bash:**

```bash
curl -i -X POST http://localhost:8082/api/create \
  -H "Content-Type: application/json" \
  -d '{"email":"firstname.lastname@kibit.edu.ua","amount":100}'
```

**Windows PowerShell:**

```powershell
Invoke-RestMethod -Uri 'http://localhost:8082/api/create' `
  -Method POST `
  -ContentType 'application/json' `
  -Body '{"email":"firstname.lastname@kibit.edu.ua","amount":100}'
```

Очікуваний HTTP-статус: **201 Created**. JSON-відповідь:

```json
{"statusCode":"201","statusMessage":"Card created successfully"}
```

## Перевірка таблиці

База H2 зберігається локально у файлі `creditdb.mv.db` і **не зникає** після перезапуску.

1. Поки застосунок працює, відкрийте `http://localhost:8082/h2-console`.
2. JDBC URL: `jdbc:h2:file:./creditdb;DB_CLOSE_ON_EXIT=FALSE`.
3. User Name: `sa`; Password — порожній.
4. Виконайте запит:

```sql
SELECT card_id, email, amount, created_at, created_by, updated_at, updated_by
FROM card
ORDER BY card_id DESC;
```

> Консоль H2 увімкнено лише для локальної навчальної розробки. Не відкривайте її для загального доступу.

## Розміщення у GitHub

Скопіюйте папку `credit` разом із `pom.xml`, `src/`, `README.md` та `.gitignore` до `web-service/credit` у вашому персональному Git-репозиторії.
Від кореня **вашого репозиторію** виконайте:

```bash
git add web-service/credit
git commit -m "Add credit create API practical work 2"
git push
```

У Google Classroom потрібно додати:

1. **Посилання на папку `web-service/credit`** у персональному GitHub-репозиторії.
2. **Файл `credit-0.0.1-SNAPSHOT.jar`**, що утворився після `mvn clean package` у папці `target/`.

Цей вихідний ZIP не містить зібраного JAR: у середовищі підготовки проєкту не було Maven та доступу до завантаження Spring-залежностей. Зберіть його локально за наведеною командою. Публікація у ваш GitHub і здавання в Classroom також виконуються з вашого облікового запису.
