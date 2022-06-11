# Executing ArchUnit Tests from a Java Library

This project is a sample to Executing ArchUnit tests from a java library

The main idea of this project came from: [Stack Overflow - Executing ArchUnit tests from a java library](https://stackoverflow.com/questions/58625936/executing-archunit-tests-from-a-java-library) 
    
## Main Stack

- [Maven](https://maven.apache.org/guides/)
- [Quarkus](https://quarkus.io/)
- [Archunit](https://www.archunit.org/)

## How it works?

Wu build a library with all Archunit test and add the lib to project via maven.

Add the dependency information to your other artifact's pom with test scope:

```
<dependency>
    <groupId>org.myproject</groupId>
    <artifactId>myproject-archunit-tests</artifactId>
  <version>1.0.0-SNAPSHOT</version>
    <scope>test</scope>
</dependency>
```

Configure Maven Surefire Plugin in your other artifact's pom so that tests are included in the test run:

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.2</version>
    <configuration>
        <dependenciesToScan>
            <dependency>org.myproject:myproject-archunit-tests</dependency>
        </dependenciesToScan>
    </configuration>
</plugin>
```


## How to build

First you must build the lib

- Go to myproject-archunit-tests folder:

```
cd myproject-archunit-tests
```

```
mvn clean install
```

- Go to code-with-quarkus:

```
cd ..
```

```
cd myproject-archunit-tests
```

```
mvn clean install
```

> **Note**
> This build should return a test error, because we create a test to validate service package and our class broke the rule.

