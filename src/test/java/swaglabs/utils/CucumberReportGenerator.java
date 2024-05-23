package swaglabs.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;

public class CucumberReportGenerator {
    public static void main(String[] args) {
        File reportOutputDirectory = new File("target");
        java.util.List<String> jsonFiles = Collections.singletonList("target/cucumber-report.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "swaglabs");
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
