package org.example.rcaagent.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;


@Component
public class LogAnalysisTool {
    @Tool(name = "log_analysis_tool")
    public String analyzeLogs(String incident) {
        if(incident.contains("500")){
            return "Potential application failure or database timeout: " ;
        }
        return "No significant issues found in logs " ;
    }
}
