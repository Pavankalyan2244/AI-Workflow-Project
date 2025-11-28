package com.example.demo.client;

import com.example.demo.model.LoanApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MlServiceClient {

    private final RestTemplate restTemplate;
    private final String mlServiceUrl;

    public MlServiceClient(RestTemplate restTemplate,
                           @Value("${ml.service.url}") String mlServiceUrl) {
        this.restTemplate = restTemplate;
        this.mlServiceUrl = mlServiceUrl;
    }

    public PredictionResponse getPrediction(LoanApplication app) {
        try {
            ResponseEntity<PredictionResponse> response =
                    restTemplate.postForEntity(mlServiceUrl, app, PredictionResponse.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error calling ML service", e);
        }
    }
}
