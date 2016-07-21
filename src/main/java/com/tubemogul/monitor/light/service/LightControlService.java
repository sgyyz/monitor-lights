package com.tubemogul.monitor.light.service;

import com.tubemogul.monitor.light.dto.LightControlDTO;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
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

    public void test(List<String> ids) {
        List<Test> tests = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            tests.add(new Test(ids.get(0), random.nextInt(10) * 10));
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (Test test : tests) {
                    Response response  = given().body("{\"value\": " + test.getValue() + "}").contentType(ContentType.JSON)
                            .post("http://localhost:8080/monitor-lights/" + test.getId());
                    
                    System.out.println(response.getBody().asString());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }

    public class Test {
        private String id;
        private int value;

        public Test(String id, int value) {
            super();
            this.id = id;
            this.value = value;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

}
