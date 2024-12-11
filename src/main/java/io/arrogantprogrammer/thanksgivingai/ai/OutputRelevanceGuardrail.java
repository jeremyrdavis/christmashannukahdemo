package io.arrogantprogrammer.thanksgivingai.ai;

import dev.langchain4j.data.message.AiMessage;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrail;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrailResult;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OutputRelevanceGuardrail implements OutputGuardrail {

    private final RelevanceAiService relevanceAiService;

    public OutputRelevanceGuardrail(RelevanceAiService relevanceAiService) {
        this.relevanceAiService = relevanceAiService;
    }

    @Override
    public OutputGuardrailResult validate(AiMessage aiMessage) {
        double result = relevanceAiService.isValid(aiMessage.text());
        if (result > 0.7) {
            Log.debugf("Unappealing menu detected. Relevance score: %f", result);
            return failure("Unappealing menu");
        }
        Log.debugf("Appealing menu");
        return success();
    }
}
