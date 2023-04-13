package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions", // the folder which contains test step definitions
        tags = "@aaaaa",
        dryRun = false  // defaultta false olacak.
)

// Cucumber-JIRA Intellij configuration
/*
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@TEST_MYP-20",
        dryRun = false
)*/


public class Runner {

}
