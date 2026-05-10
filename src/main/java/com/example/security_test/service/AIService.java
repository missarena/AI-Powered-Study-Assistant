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

        String prompt = """
        Generate questions from the following content.

        Return in this exact readable format only:

        MCQs:
        1. Question?
        A. option
        B. option
        C. option
        D. option
        Answer: A

        Short Questions:
        1. Question?

        Conceptual Questions:
        1. Question?

        Content:
        """ + content;

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
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