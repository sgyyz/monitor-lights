package com.tubemogul.monitor.light.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tubemogul.monitor.light.entity.ProductEntity;

@Path("/monitor-lights")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private static final Map<String, ProductEntity> productMap = new HashMap<>();

    @GET
    public List<ProductEntity> findAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewProduct(ProductEntity entity) {
        productMap.put(getRandomId(), entity);
        return Response.ok().build();
    }

    // This can update from any place if they post this entity
    // 1. update from sentinel, or other service, or 
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") Integer id, ProductEntity entity) {
        // TODO: 1. FIND THE ENTITY BY ID
        // TODO: 2. UPDATE THE FIELDS EXCEPT FIELD
        // TODO: 3. CALL XIAODONG'S API TO CHANGE THE LIGHTS
        return Response.ok().build();
    }
    
    private static String getRandomId() {
        return UUID.randomUUID().toString();
    }
}
