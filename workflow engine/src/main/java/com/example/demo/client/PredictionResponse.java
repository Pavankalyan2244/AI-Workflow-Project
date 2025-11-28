package com.example.demo.client;

public class PredictionResponse {

    private String prediction; // APPROVE / REJECT / REVIEW
    private double confidence;

    public PredictionResponse() {
    }

    public PredictionResponse(String prediction, double confidence) {
        this.prediction = prediction;
        this.confidence = confidence;
    }

    public String getPrediction() {
        return prediction;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
