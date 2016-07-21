package com.tubemogul.monitor.light;

import com.tubemogul.monitor.light.config.MonitorLightsConfiguration;
import com.tubemogul.monitor.light.resources.TestResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MonitorLightsApp extends Application<MonitorLightsConfiguration> {
    public static void main(String[] args) throws Exception {
        new MonitorLightsApp().run(args);
    }

    @Override
    public void run(MonitorLightsConfiguration cfg, Environment env) throws Exception {
        // resources
        final TestResource testResource = new TestResource();
        env.jersey().register(testResource);
    }
}
