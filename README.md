# Project for UI automated testing for bookedby.com
## :pushpin: Contains:

- [Technology stack](#stack-technology-stack)
- [Test run](#run-test-run)
- [—борка в Jenkins](#-сборка-в-jenkins)
- [ѕример Allure-отчета](#-пример-allure-отчета)
- [”ведомлени€ в Telegram с использованием бота](#-уведомлени€-в-telegram-с-использованием-бота)
- [¬идео примера запуска теста в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :stack: Technology stack

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Automated tests on <code>Java</code> using <code>JUnit 5</code> and <code>Gradle</code>.
For UI-test was used framework [Selenide](https://selenide.org/).
You can run tests locally or with Jenkins job that use [Selenoid](https://aerokube.com/selenoid/).
Allure report is formed for every running and common results are sent to <code>Telegram</code>.

Allure-report includes:
* steps;
* screenshots;
* Page Source;
* console logs;
* autotest video.

## :run: test run

### Local test run
With default options
```
gradle clean test
```

You can change options
```
clean
test
-Dbrowser_name=${BROWSER_NAME}
-Dbrowser_version=${BROWSER_VERSION}
-Dbrowser_size=${BROWSER_SIZE}
```

### Remote running

```
clean
test
-Dbrowser_name=${BROWSER_NAME}
-Dbrowser_version=${BROWSER_VERSION}
-Dbrowser_size=${BROWSER_SIZE}
-Dselenide.remote=${REMOTE_BROWSER_URL}
```

### Options

* <code>BROWSER_NAME</code> Ц browser for running tests. default - <code>chrome</code>.
* <code>BROWSER_VERSION</code> Ц browser version for running. default - <code>105.0</code>.
* <code>BROWSER_SIZE</code> Ц browser size for running tests. default - <code>1920x1080</code>.
* <code>TASK</code> Ц you can run all tests or only smoke tests.
* <code>REMOTE_BROWSER_URL</code> - remote url.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Jenkins job
<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkins_1.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Allure report
### Overview

<p align="center">
<img title="Allure Overview" src="images/screenshots/allure-report.png">
</p>

### Result

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allure-report.png>
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications from bot

After tests done telegram-bot  <code>Telegram</code>, automatically processes and sends a run report message.


<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/telegram.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.svg"> ¬идео примера запуска теста в Selenoid

Video example that you could find in each test result.
<p align="center">
  <img title="Selenoid Video" src="images/gif/videoExample.gif">
</p>
