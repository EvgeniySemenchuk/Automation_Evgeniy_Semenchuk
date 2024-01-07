1.mvn versions:display-dependency-updates
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ............... 4.15.0 -> 4.16.1
[INFO]   org.testng:testng ..................................... 7.8.0 -> 7.9.0

2. mvn clean test -Dsuite=TEST_ONLY -Dconfig=saucedemo
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.671 s - in TestSuite

3. mvn clean test -Dsuite=TEST_ONLY -Dconfig=saucedemo -Dlogin=standard_user -Dpassword=secret_sauce
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.213 s - in TestSuite

