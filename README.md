# Selenium-TestNG Web Automation

---
This is a web automation project that automates the testing of the [OrangeHRM Demo website](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)    using Selenium WebDriver and Java.
It follows best practices like the Page Object Model (POM), Singleton pattern, and Browser Factory pattern. The project uses Allure report to generate detailed and interactive reports of the test results.

---
#### Test Scenarios
1. Login to the OrangeHRM Demo site.
2. Create two new employees and save their details to a JSON list.
3. Go to the PIM dashboard and search for the first user by name. Assert that the user is found.
4. Click on the first user from the search table and update their ID with a random user ID.
5. Search for the first user by their new user ID from the PIM dashboard menu. Assert that the user is found.
6. Logout of the admin account and login with the second user from the JSON list.
7. Click on the "My Info" menu and select the "Gender" and "Blood Type" fields. Save the changes.
8. Input the address and email details in the "Contact Details" section.
9. Logout of the second user's account.



### Languages And Frameworks
|                       |              |
|-----------------------|--------------|
| Programming Language  | **Java**     |
|  Web Automation Tool  | **Selenium** |
| Browser Driver Management Library  | **WebDriverManager**     |
|  Testing Framework  | **TestNG**|
| Build Tool  |**Gradle**     |
|  IDE  | **IntelliJ** |
| Test Reporting Framework |**Allure**     |
|  Logger   | **log4j** |


---
#### How to run the project
1. Clone this project
2. Open cmd in the root folder
3. Give the following command.

```
gradle clean test
 ```

#### How to generate allure report
1. Open cmd in the root folder
2.  Give the following commands

```
allure generate allure-results --clean -o allure-report
```
```
allure serve allure-results
```
---

### Generated Reports
![img](https://user-images.githubusercontent.com/41513761/221497380-0458ecba-fcf8-471e-8851-b9f79e697dd3.png)
![img_1](https://user-images.githubusercontent.com/41513761/221497396-42ba53c5-62bd-4e3b-8ae8-7d7ae7a1b975.png)

---

#### Feedback
If you have any feedback, please reach out to me at md.mostafa.akash@gmail.com
