package com.example.VitraAi.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty", "json:target/cucumber.json","html:target/CucumberTestReport.html"}, snippets = CAMELCASE)
public class
CucumberTest {
}
