# 🚀 Java CI/CD Demo

A simple **Java CI/CD demo** project showing how to automate builds and tests using **GitHub Actions** and **Maven**.
It includes a basic Java method, a corresponding **JUnit 5** test, and a CI/CD workflow that runs automatically on push and pull requests.


## Project Overview

* **Language:** Java 21
* **Build Tool:** Maven
* **Test Framework:** JUnit 5
* **CI/CD Platform:** GitHub Actions

## Project Structure

```
java-ci-cd-demo/
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── Main.java
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   └── MainTest.java
├── pom.xml
└── README.md
```

## Code Explanation

### **Main.java**

```java
package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from Java CI CD demo");
    }

    public String greet(String name) {
        return "Hello, " + name;
    }
}
```

### **MainTest.java**

```java
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testGreet() {
        Main main = new Main();
        var greeting = main.greet("Ashish");
        assertEquals("Hello, Ashish", greeting);
    }
}
```

## GitHub Actions Workflow

The `.github/workflows/ci.yml` file automates building and testing with Maven.

```yaml
name: Java CI CD

on:
  push:
    branches: [ "master" ]
  pull_request:
    branches: [ "master" ]

jobs:
  builds:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout source code
        uses: actions/checkout@v4

      - name: Setup JDK 21
        uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'

      - name: Build with maven
        run: mvn -B package --file pom.xml

      - name: Run tests
        run: mvn test
```

---

## Workflow Steps Explained

1. **Trigger:** Runs on every push or pull request to `master`.
2. **Checkout:** Pulls source code into the CI environment.
3. **Setup JDK:** Installs Java 21 (Temurin).
4. **Build:** Compiles and packages using Maven.
5. **Test:** Runs JUnit tests to verify correctness.

## Run Locally

### Clone the repository:

```bash
git clone https://github.com/<your-username>/java-ci-cd-demo.git
cd java-ci-cd-demo
```

### Build the project:

```bash
mvn clean package
```

### Run the tests:

```bash
mvn test
```

### Run the application:

```bash
java -cp target/java-ci-cd-demo-1.0-SNAPSHOT.jar org.example.Main
```

## Expected Outputs

**From application:**

```
Hello from Java CI CD demo
```

**From tests:**

```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## Tools Used

| Tool               | Purpose                                    |
| ------------------ | ------------------------------------------ |
| **Java 21**        | Language and runtime                       |
| **Maven**          | Build automation and dependency management |
| **JUnit 5**        | Unit testing                               |
| **GitHub Actions** | CI/CD automation                           |

## Key Highlights

✅ Minimal Java project with CI/CD setup
✅ Automated build and test execution
✅ Ensures quality and continuous integration
✅ Ready-to-use for beginners learning CI/CD