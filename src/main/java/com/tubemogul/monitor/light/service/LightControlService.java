package com.tubemogul.monitor.light.service;

import com.tubemogul.monitor.light.dto.LightControlDTO;

import static com.jayway.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;

public class LightControlService {
    public boolean changeLightColor(String remoteServiceUrl, LightControlDTO lightControlDTO)
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(lightControlDTO);
        Response response = given().contentType(MediaType.APPLICATION_JSON).post(remoteServiceUrl, json);
        if (response.getStatusCode() == 200) {
            return true;
        }

        return false;
    }

}
