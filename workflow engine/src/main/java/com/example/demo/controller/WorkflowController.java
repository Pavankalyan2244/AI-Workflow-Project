package com.example.demo.controller;

import com.example.demo.model.LoanApplication;
import com.example.demo.rules.DecisionOutcome;
import com.example.demo.service.WorkflowEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workflow")
public class WorkflowController {

    private final WorkflowEngineService engineService;

    public WorkflowController(WorkflowEngineService engineService) {
        this.engineService = engineService;
    }

    @PostMapping("/process")
    public DecisionOutcome process(@RequestBody LoanApplication app) {
        if (app.getId() == null || app.getId().isBlank()) {
            app.setId("generated-" + System.currentTimeMillis());
        }
        return engineService.process(app);
    }
}
