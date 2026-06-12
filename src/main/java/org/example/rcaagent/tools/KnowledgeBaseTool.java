package org.example.rcaagent.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class KnowledgeBaseTool {
    @Tool(name = "knowledge_analysis_tool")
    public String search(String incident) {
        return """
                Similar Incidents #INC32101
                Issue caused by database timeout, resolved by increasing connection pool size.""";
    }

}
