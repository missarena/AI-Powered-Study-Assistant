package com.example.security_test.service;

import com.example.security_test.Entity.AiResponse;
import com.example.security_test.repository.AiResponseRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AIService {

    private final ChatClient chatClient;

    @Autowired
    private AiResponseRepository aiResponseRepository;

    public AIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // ---------------- SUMMARIZATION ----------------
    public String summarize(String noteContent, Long noteId) {

        String summary = chatClient.prompt()
                .user("Summarize in 5 bullet points:\n" + noteContent)
                .call()
                .content();

        AiResponse aiResponse = new AiResponse();
        aiResponse.setNoteId(noteId);
        aiResponse.setType("SUMMARY");
        aiResponse.setResponse(summary);
        aiResponse.setCreatedAt(LocalDateTime.now());

        aiResponseRepository.save(aiResponse);

        return summary;
    }

    // ---------------- QUESTION GENERATOR ----------------
    public String generateQuestions(String content) {

        if (content == null || content.isBlank()) {
            return "Content cannot be empty";
        }

        String prompt = buildJsonPrompt(content);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    private String buildJsonPrompt(String content) {
        return """
    You are an expert teacher.

    Generate questions from the given content and return ONLY valid JSON.

    STRICT FORMAT:
    {
      "mcqs": [
        {
          "question": "",
          "options": ["A", "B", "C", "D"],
          "answer": ""
        }
      ],
      "shortQuestions": [],
      "conceptualQuestions": []
    }

    Rules:
    - ONLY JSON output
    - No explanation, no markdown
    - Ensure valid JSON

    CONTENT:
    """ + content;
    }

    // ---------------- GET SUMMARY ----------------
    public String getLatestSummary(Long noteId) {

        List<AiResponse> list =
                aiResponseRepository.findByNoteIdAndTypeOrderByCreatedAtDesc(noteId, "SUMMARY");

        if (list.isEmpty()) {
            return "No summary found for this note";
        }

        return list.get(0).getResponse();
    }
}