package org.acme;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@ArchTag("example")
@AnalyzeClasses(packages = "org.acme")
public class NamingConventionTest {

    @ArchTest
    static ArchRule services_should_be_prefixed =
            classes()
                    .that().resideInAPackage("..service..")
                    .should().haveSimpleNameStartingWith("Service");
}