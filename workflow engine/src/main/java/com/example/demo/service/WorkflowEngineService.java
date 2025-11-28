package com.example.demo.service;

import com.example.demo.client.MlServiceClient;
import com.example.demo.client.PredictionResponse;
import com.example.demo.model.LoanApplication;
import com.example.demo.rules.DecisionOutcome;
import com.example.demo.rules.RuleEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WorkflowEngineService {

    private static final Logger log = LoggerFactory.getLogger(WorkflowEngineService.class);

    private final MlServiceClient mlServiceClient;
    private final RuleEngine ruleEngine;

    public WorkflowEngineService(MlServiceClient mlServiceClient, RuleEngine ruleEngine) {
        this.mlServiceClient = mlServiceClient;
        this.ruleEngine = ruleEngine;
    }

    public DecisionOutcome process(LoanApplication app) {
        long start = System.currentTimeMillis();
        try {
            PredictionResponse prediction = mlServiceClient.getPrediction(app);
            DecisionOutcome outcome = ruleEngine.decide(app, prediction);
            long duration = System.currentTimeMillis() - start;

            log.info("workflow_decision appId={} outcome={} prediction={} confidence={} durationMs={}",
                    app.getId(),
                    outcome,
                    prediction.getPrediction(),
                    prediction.getConfidence(),
                    duration
            );

            return outcome;
        } catch (Exception e) {
            log.error("workflow_error appId={} message={}", app.getId(), e.getMessage(), e);
            throw e;
        }
    }
}
