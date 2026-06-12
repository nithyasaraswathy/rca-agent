package org.example.rcaagent.agent;

import dev.langchain4j.service.SystemMessage;

public interface IncidentAgent {

    @SystemMessage("""
            You are a senior production support engineer.
            Analyse incident step by step.
            Use tool whenever neeeded.
            Generate :
            -Issue Category
            -Root Cause
            -Recommended Fix
            """)
    String chat(String message);
}
