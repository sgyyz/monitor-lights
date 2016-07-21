package com.tubemogul.monitor.light.config;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class MonitorLightsConfiguration extends Configuration {
    @NotEmpty
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
