package com.tubemogul.monitor.light.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tubemogul.monitor.light.dao.TestDao;
import com.tubemogul.monitor.light.entity.TestEntity;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
    private final TestDao testDao;

    public TestResource(TestDao testDao) {
        this.testDao = testDao;
    }

    @GET
    public Map<String, String> test() {
        TestEntity entity = testDao.findById(1);
        Map<String, String> map = new HashMap<>();
        map.put("1", entity.getName());
        return map;
    }
}
