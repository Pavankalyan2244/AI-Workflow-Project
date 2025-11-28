package com.example.demo.model;

public class LoanApplication {

    private String id;
    private String customerId;
    private double amount;
    private int creditScore;
    private double existingDebt;

    public LoanApplication() {
    }

    public LoanApplication(String id, String customerId, double amount, int creditScore, double existingDebt) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.creditScore = creditScore;
        this.existingDebt = existingDebt;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getExistingDebt() {
        return existingDebt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setExistingDebt(double existingDebt) {
        this.existingDebt = existingDebt;
    }
}
