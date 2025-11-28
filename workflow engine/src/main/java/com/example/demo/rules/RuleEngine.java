package com.example.demo.rules;

import com.example.demo.client.PredictionResponse;
import com.example.demo.model.LoanApplication;
import org.springframework.stereotype.Service;

@Service
public class RuleEngine {

    private static final double AUTO_APPROVE_CONF = 0.9;
    private static final double AUTO_REJECT_CONF = 0.85;
    private static final double MAX_AUTO_APPROVE_AMOUNT = 5000;
    private static final double MIN_AUTO_REJECT_AMOUNT = 10000;

    public DecisionOutcome decide(LoanApplication app, PredictionResponse prediction) {
        double conf = prediction.getConfidence();
        String pred = prediction.getPrediction();

        if ("APPROVE".equals(pred)
                && conf >= AUTO_APPROVE_CONF
                && app.getAmount() <= MAX_AUTO_APPROVE_AMOUNT) {
            return DecisionOutcome.AUTO_APPROVE;
        }

        if ("REJECT".equals(pred)
                && conf >= AUTO_REJECT_CONF
                && app.getAmount() >= MIN_AUTO_REJECT_AMOUNT) {
            return DecisionOutcome.AUTO_REJECT;
        }

        return DecisionOutcome.MANUAL_REVIEW;
    }
}
