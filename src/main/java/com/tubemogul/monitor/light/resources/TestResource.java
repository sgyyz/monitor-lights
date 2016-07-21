package com.tubemogul.monitor.light.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
    
    @GET
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "abc");
        return map;
    }
}
