package cn.printf.demos.archunit;


import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class ArchUnitTest {

    @Test
    public void file_name_should_end_with_package_name() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(this.getClass().getPackage().getName());
        classes().that().resideInAPackage("..controller")
                .should().haveSimpleNameEndingWith("Controller")
                .check(importedClasses);
        classes().that().resideInAPackage("..service")
                .should().haveSimpleNameEndingWith("Service")
                .check(importedClasses);
        classes().that().resideInAPackage("..dao")
                .should().haveSimpleNameEndingWith("Dao")
                .check(importedClasses);
    }

    @Test
    public void should_obey_MVC_architecture_rule() {
        layeredArchitecture()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Dao").definedBy("..dao..")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                .whereLayer("Dao").mayOnlyBeAccessedByLayers("Service");
    }
}
