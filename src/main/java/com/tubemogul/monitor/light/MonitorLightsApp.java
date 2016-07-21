package com.tubemogul.monitor.light;

import org.skife.jdbi.v2.DBI;

import com.tubemogul.monitor.light.config.MonitorLightsConfiguration;
import com.tubemogul.monitor.light.dao.TestDao;
import com.tubemogul.monitor.light.resources.TestResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
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
        // dao level
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(env, cfg.getDataSourceFactory(), "mysql");
        final TestDao dao = dbi.onDemand(TestDao.class);
        
        
        final TestResource testResource = new TestResource(dao);
        env.jersey().register(testResource);
    }
}
