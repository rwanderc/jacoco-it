# JaCoCoIT

This is a project to exemplify JaCoCo in Maven covering unit and integration tests. This also covers Netbeans
requirements to create its report.

### Enviornment

* Java JDK 1.8.0_73-b02
* Maven 3.3.9
* NetBeans IDE 8.2 (Build 201609300101)
* JaCoCo, Failsafe and Surefire versions are described in the pom.xml

## Running the tests

By running `mvn clean package`, Maven will only run unit tests and then produce coverage report only for these tests.
By running `mvn clean install`, Maven will run unit and integration tests, and the Netbeans coverage report will cover both. The reports folder, however, will contain 3 variations of the reports: jacoco-ut with only unit tests; jacoco-it with only integration tests; and jacoco with both merged.

The execution steps in JaCoCo configuration defines different achievements. Unit tests produce the jacoco-ut related 
files and folders, while Integration tests produce the jacoco-it related files and folders.

However, Netbeans needs the folder **jacoco** in the reports folder to read the XML file with the results to generate the visual report. For that purpose, 3 other execution steps are added:
* the first, **post-unit-test-for-netbeans**, is to create the jacoco report right after unit tests, in case only they are run, so Netbeans can show the report from `mvn clean package`.
* the second, **merge-results**, merges the results from jacoco-ut.exec and jacoco-it.exec into one single file jacoco.exec.
* and the third, **post-merge-report**, replaces the jacoco report folder with the merged result. Thus, Netbeans can read the results from the merged file, and provide full information about both unit and integration tests run by `mvn clean install` or `mvn clean verify`.

The following URL describes that Netbeans does not use the **jacoco.exec** file to create the visual report. Instead, it is read from the **jacoco.xml** file produced from the reports goal: https://netbeans.org/bugzilla/show_bug.cgi?id=223319#jacoco-it
