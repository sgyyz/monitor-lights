package com.tubemogul.monitor.light;


import com.tubemogul.monitor.light.config.MonitorLightsConfiguration;
import com.tubemogul.monitor.light.resources.ProductResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MonitorLightsApp extends Application<MonitorLightsConfiguration> {
    public static void main(String[] args) throws Exception {
        new MonitorLightsApp().run(args);
    }

    @Override
    public void run(MonitorLightsConfiguration cfg, Environment env) throws Exception {
        registerResources(cfg, env);
    }

    @Override
    public void initialize(Bootstrap<MonitorLightsConfiguration> bootstrap) {
        
    }
    
    
    private void registerResources(MonitorLightsConfiguration cfg, Environment env) throws ClassNotFoundException {
        // create the resource
        final ProductResource productResource = new ProductResource();
        env.jersey().register(productResource);
    }
}
