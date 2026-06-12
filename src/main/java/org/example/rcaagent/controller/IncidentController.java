package org.example.rcaagent.controller;

import lombok.RequiredArgsConstructor;
import org.example.rcaagent.agent.IncidentAgent;
import org.example.rcaagent.model.IncidentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentAgent incidentAgent;

    @PostMapping("/analyze")
    public String analyzeIncident(@RequestBody IncidentRequest request) {
        return incidentAgent.chat(request.incidentDescription());
    }


}
