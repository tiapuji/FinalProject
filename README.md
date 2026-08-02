# Automation Testing

Repository ini berisi automation testing untuk website **SauceDemo** dan api **dummyapi.io** menggunakan Selenium WebDriver dan JUnit.

## Tech Stack

- Java 11 (Oracle OpenJDK 11.0.28)
- Selenium WebDriver
- JUnit
- Gradle
- Cucumber
- IntelliJ IDEA
- Cucumber HTML & JSON Report

## Project Structure

```
src
    ├───main
    │   ├───java
    │   │   └───org
    │   │       └───example
    │   │               Main.java
    │   │
    │   └───resources
    └───test
        ├───java
        │   ├───features
        │   │       api.feature
        │   │       web.feature
        │   │
        │   ├───helper
        │   │   │   Endpoint.java
        │   │   │   Models.java
        │   │   │   ScenarioContext.java
        │   │   │   Utility.java
        │   │   │
        │   │   └───JSONSchemaData
        │   │           get_list_tags.json
        │   │           get_list_user.json
        │   │           post_create_user.json
        │   │           update_user.json
        │   │
        │   ├───pages
        │   │       ApiPage.java
        │   │       WebPage.java
        │   │
        │   ├───runner
        │   │       AllRunner.java
        │   │       ApiRunner.java
        │   │       WebRunner.java
        │   │
        │   └───stepDef
        │           ApiStep.java
        │           Hooks.java
        │           WebStep.java
        │
        └───resources

```

## Menjalankan Test

### Melalui IntelliJ IDEA

1. Buka project.
2. Masuk ke folder:

```
src/test/java/runner
```

3. Pilih salah satu runner:
    - `WebRunner.java` → menjalankan automation web.
    - `ApiRunner.java` → menjalankan automation API.
    - `AllRunner.java` → menjalankan seluruh test.

4. Klik kanan pada runner, lalu pilih **Run**.

### Melalui Terminal

1. Buka project.
2. Pilih terminal.
3. Lalu running salah satu: 

untuk menjalankan semua skenario :
```
.\gradlew clean test
```
untuk menjalankan skenario api :
```
.\gradlew test --tests runner.ApiRunner
```
untuk menjalankan skenario we :
```
.\gradlew test --tests runner.WebRunner
```

## Report

Setelah test selesai, report dapat dilihat pada folder:

```
reports/
```