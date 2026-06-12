package org.example.rcaagent.config;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import org.example.rcaagent.agent.IncidentAgent;
import org.example.rcaagent.tools.LogAnalysisTool;
import org.example.rcaagent.tools.KnowledgeBaseTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    GoogleAiGeminiChatModel googleAiGeminiChatModel(@Value("${gemini.api-key}") String apiKey) {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash").build();

    }

    @Bean
    IncidentAgent incidentAgent(GoogleAiGeminiChatModel googleAiGeminiChatModel, LogAnalysisTool logAnalysisTool,KnowledgeBaseTool knowledgeBaseTool) {
        return AiServices.builder(IncidentAgent.class)
                .chatModel(googleAiGeminiChatModel)
                .tools(logAnalysisTool,
                        knowledgeBaseTool)
                .build();
    }

}

