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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tubemogul.monitor.light.dto.LightChangeDTO;
import com.tubemogul.monitor.light.dto.LightControlDTO;
import com.tubemogul.monitor.light.dto.ProductDTO;
import com.tubemogul.monitor.light.dto.LightStatus;
import com.tubemogul.monitor.light.enums.Method;
import com.tubemogul.monitor.light.service.LightControlService;

import io.dropwizard.jersey.errors.ErrorMessage;

@Path("/monitor-lights")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);
    private static final Map<String, ProductDTO> productMap = new HashMap<>();

    private final String remoteServiceUrl;

    public ProductResource(String remoteServiceUrl) {
        this.remoteServiceUrl = remoteServiceUrl;
    }

    @GET
    public List<ProductDTO> findAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewProduct(ProductDTO entity) {
        LOGGER.debug("save: {}", entity);
        String id = getRandomId();
        entity.setId(id);

        productMap.put(id, entity);
        return Response.ok().entity(entity).build();
    }

    // This can update from any place if they post this entity
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") String id, ProductDTO product) throws JsonProcessingException {
        ProductDTO oldProduct = productMap.get(id);
        if (oldProduct == null) {
            return Response.serverError().entity(new ErrorMessage("Can't find product.")).build();
        }

        productMap.put(id, product);
        return Response.ok().entity(product).build();
    }

    @Path("/{id}")
    @POST
    @Consumes
    public Response controlLights(@PathParam("id") String id, LightChangeDTO lightChangeDTO) {
        ProductDTO productDTO = productMap.get(id);
        LightControlDTO lightControlDTO = buildLightControlDTO(lightChangeDTO.getValue(), productDTO);

        LOGGER.debug("light change: {}", lightControlDTO);

        LightControlService service = new LightControlService();
        try {
            if (service.changeLightColor(remoteServiceUrl, lightControlDTO)) {
                return Response.ok().entity(lightControlDTO).build();
            }
        } catch (JsonProcessingException e) {
            LOGGER.error("parsing error: {}", e);
            return Response.serverError().entity(new ErrorMessage("Can't build json to call server")).build();
        }
        return Response.serverError().entity(new ErrorMessage("Can't change the light color")).build();
    }

    private LightControlDTO buildLightControlDTO(int currentValue, ProductDTO productDTO) {
        LightControlDTO lightControlDTO = new LightControlDTO();

        int rgbValue = getRgbValue(currentValue, productDTO);
        Method method = rgbValue == -1 ? Method.SET_POWER : Method.SET_RGB;
        lightControlDTO.setMethod(method);
        lightControlDTO.setLightId(productDTO.getLightId());
        lightControlDTO.setPower(Method.SET_POWER.equals(method) ? "off" : "on");
        lightControlDTO.setRgbValue(rgbValue);

        return lightControlDTO;
    }

    private int getRgbValue(int currentValue, ProductDTO productDTO) {
        List<LightStatus> status = productDTO.getStatusList();
        for (LightStatus lightStatus : status) {
            if (currentValue > lightStatus.getStartValue() && currentValue <= lightStatus.getEndValue()) {
                return lightStatus.getRgbValue();
            }
        }
        return -1;
    }

    private static String getRandomId() {
        return UUID.randomUUID().toString();
    }
}
