# Appium Mobile Web Automation (Java + TestNG + Gradle)

This project provides cross-platform mobile web automation using:
- **Android + Chrome** (Appium + UiAutomator2)
- **iOS + Safari** (Appium + XCUITest)
- **TestNG** for test execution
- **Allure** for reporting
- **Azure DevOps pipeline** for CI

## Tech stack and dependency versions

The core dependencies are kept as requested:
- `io.appium:java-client:9.1.0`
- `org.seleniumhq.selenium:selenium-java:4.18.1`
- `org.testng:testng:7.9.0`
- `org.junit.jupiter:junit-jupiter:5.10.2`

Allure support is added on top with:
- `io.qameta.allure:allure-testng:2.29.1`
- `io.qameta.allure` Gradle plugin

## Project structure

```text
src/test/java/com/elevra/base/BaseTest.java
src/test/java/com/elevra/core/DriverContext.java
src/test/java/com/elevra/driver/AndroidDriverManager.java
src/test/java/com/elevra/driver/IPadDriverManager.java
src/test/java/com/elevra/driver/DriverFactory.java
src/test/java/com/elevra/utils/WaitUtils.java
src/test/java/com/elevra/tests/ElevraSmokeTests.java
src/test/resources/testng.xml
src/test/resources/allure.properties
azure-pipelines.yml
```

## Run tests locally

1. Start Appium server (default expected URL: `http://127.0.0.1:4723`)
2. Start emulator/simulator
3. Run one of the following:

### Android Chrome run

```bash
./gradlew clean test allureReport \
  -DplatformName=android \
  -DbrowserName=chrome \
  -DappiumServerUrl=http://127.0.0.1:4723 \
  -DdeviceName="Android Emulator"
```

### iOS Safari run

```bash
./gradlew clean test allureReport \
  -DplatformName=ios \
  -DbrowserName=safari \
  -DappiumServerUrl=http://127.0.0.1:4723 \
  -DdeviceName="iPad Air 13-inch (M3)" \
  -DplatformVersion=26.2
```

## Allure report

After test execution:

```bash
./gradlew allureReport
```

Generated report path:
- `build/reports/allure-report`

Allure raw results path:
- `build/allure-results`

## Azure DevOps pipeline

`azure-pipelines.yml` runs a matrix:
- `android + chrome`
- `ios + safari`

The pipeline publishes:
- TestNG XML test results
- Allure results artifacts
- Allure HTML report artifacts
