package com.vegas;

import cucumber.api.SnippetType;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Java\\LastCucumber\\src\\main\\resources\\features",
        glue = "com.vegas",
        snippets = SnippetType.CAMELCASE)
public class RunnerTest {

}