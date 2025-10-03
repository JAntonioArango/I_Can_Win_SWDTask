# I Can Win - Selenium WebDriver Task

A Selenium WebDriver automation testing project that demonstrates automated testing of Pastebin functionality using the Page Object Model pattern.

![Java](https://img.shields.io/badge/Java-21-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.25.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.7.0-orange)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red)

## 📋 Project Overview

This project implements automated web testing for Pastebin using Selenium WebDriver with Java. It follows the Page Object Model (POM) design pattern to create maintainable and reusable test automation code.

### Key Features
- **Page Object Model**: Clean separation of test logic and page elements
- **Custom Wait Conditions**: Enhanced waiting strategies for reliable test execution
- **TestNG Integration**: Comprehensive test framework with annotations and assertions
- **Cross-browser Support**: Configured for Chrome WebDriver with extensibility for other browsers

## 🛠️ Technologies Used

- **Java 21**: Modern Java features and performance improvements
- **Selenium WebDriver 4.25.0**: Latest web automation framework
- **TestNG 7.7.0**: Testing framework for test organization and execution
- **Maven**: Dependency management and build automation
- **Logback**: Logging framework for test execution monitoring

## 📁 Project Structure

```
I_Can_Win_SWDTask/
├── src/
│   ├── main/java/
│   │   └── org/example/
│   │       └── Main.java
│   └── test/java/
│       ├── PageObject_Model/
│       │   ├── AbstractPage.java
│       │   ├── PastebinHomePage.java
│       │   └── PastebinTest.java
│       ├── Test/
│       │   └── WebDriverPastebinTest.java
│       └── Waits/
│           └── CustomConditions.java
├── pom.xml
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- **Java 21** or higher installed
- **Maven 3.6+** installed
- **Chrome Browser** installed
- **ChromeDriver** (automatically managed by Selenium Manager)

### Local Setup and Deployment

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd I_Can_Win_SWDTask
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run the tests**
   ```bash
   # Run all tests
   mvn test
   
   # Run specific test class
   mvn test -Dtest=PastebinTest
   ```

4. **Compile the project**
   ```bash
   mvn compile
   ```

## 🧪 Test Execution

### Running Tests via IDE
- Import the project into your preferred IDE (IntelliJ IDEA, Eclipse, VS Code)
- Navigate to test classes in `src/test/java/`
- Right-click and run individual tests or test classes

### Running Tests via Command Line
```bash
# Execute all tests with verbose output
mvn test -Dtest=PastebinTest -DsuiteXmlFile=testng.xml

# Run tests with specific browser (if configured)
mvn test -Dbrowser=chrome
```

## 📊 Test Reports

TestNG generates detailed test reports in:
- `target/surefire-reports/` - Maven Surefire reports
- `test-output/` - TestNG native reports

## 🔧 Configuration

### Browser Configuration
The project is configured to use Chrome WebDriver by default. To use different browsers:
1. Add appropriate WebDriver dependencies to `pom.xml`
2. Modify the browser setup in test classes
3. Update WebDriver initialization in `@BeforeMethod`

### Test Data Management
- Test data is currently hardcoded in test methods
- Consider externalizing test data to properties files or JSON for better maintainability

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is created for educational and demonstration purposes.

---

**Note**: Ensure Chrome browser is installed and up-to-date for optimal test execution. The project uses Selenium Manager for automatic WebDriver management.