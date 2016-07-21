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

import com.tubemogul.monitor.light.dto.ProductDTO;
import com.tubemogul.monitor.light.enums.ColorEnum;

@Path("/monitor-lights")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private static final Map<String, ProductDTO> productMap = new HashMap<>();

    @GET
    public List<ProductDTO> findAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewProduct(ProductDTO entity) {
        String id = getRandomId();
        entity.setId(id);
        
        productMap.put(getRandomId(), entity);
        return Response.ok().entity(entity).build();
    }

    // This can update from any place if they post this entity
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") String id, ProductDTO product) {
        productMap.put(id, product);

        // TODO: 3. CALL XIAODONG'S API TO CHANGE THE LIGHTS
        return Response.ok().entity(getLightColor(product)).build();
    }

    private ColorEnum getLightColor(ProductDTO product) {
        if (product.getSuccessRatio() <= product.getRedLight()) {
            return ColorEnum.RED;
        } else if (product.getSuccessRatio() > product.getRedLight()
                && product.getSuccessRatio() <= product.getYellowLight()) {
            return ColorEnum.YELLOW;
        } else if (product.getSuccessRatio() > product.getGreenLight()) {
            return ColorEnum.GREEN;
        } else {
            return ColorEnum.RED;
        }
    }

    private static String getRandomId() {
        return UUID.randomUUID().toString();
    }
}
