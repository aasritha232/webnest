package pro.webnest.ai;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

   /* @Value("${ai.api.key}")
    private String apiKey;

    @Value("${ai.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String getAIResponse(String userMessage) {

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        // Request body (OpenAI format)
        Map<String, Object> body = new HashMap<>();
       
        body.put("model", "gpt-4o-mini");


        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "user", "content", userMessage));
        body.put("messages", messages);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        try {
            Map response = restTemplate.postForObject(
                    apiUrl,
                    request,
                    Map.class
            );

            List choices = (List) response.get("choices");
            Map choice = (Map) choices.get(0);
            Map message = (Map) choice.get("message");

            return message.get("content").toString();

        } catch (Exception e) {
            return "⚠️ AI service is currently unavailable.";
        }
    }*/
    public String getAIResponse(String userMessage) {

        String msg = userMessage.toLowerCase();

        if (msg.contains("webnest")) {
            return "WebNest is a unified dashboard that brings social platforms and AI assistance into one place.";
        }
        if (msg.contains("youtube")) {
            return "YouTube is integrated in WebNest for easy access to videos and learning content.";
        }
        if (msg.contains("facebook")) {
            return "Facebook is available inside WebNest through a dedicated section.";
        }
        if (msg.contains("hello") || msg.contains("hi")) {
            return "Hello! Welcome to WebNest AI. How can I help you?";
        }

        return "I am WebNest AI. Smarter responses will be added soon.";
    }

}
