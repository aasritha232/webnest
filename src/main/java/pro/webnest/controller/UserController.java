package pro.webnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import pro.webnest.entity.User;
import pro.webnest.service.UserService;
import org.springframework.ui.Model;
import pro.webnest.ai.AIService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // maps to register.html
    }

    @GetMapping("/save-user")
    @ResponseBody
    public String saveUser() {

        User user = new User("Test", "test@gmail.com", "12345");
        userService.saveUser(user);

        return "User saved successfully!";
    }
    
    
    

    
    @PostMapping("/register")
    @ResponseBody
    public String registerUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {

        User user = new User(name, email, password);
        userService.saveUser(user);

        return "Registration successful!";
    }

    
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    
    
    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password
    ) {
        User user = userService.login(email, password);

        if (user != null) {
            return "redirect:/dashboard";
        } else {
            return "login";
        }
    }


    
    
    
    
    
    
    @GetMapping("/youtube")
    public String youtube(HttpSession session) {

        Integer count = (Integer) session.getAttribute("youtubeCount");
        if (count == null) count = 0;

        session.setAttribute("youtubeCount", count + 1);

        return "youtube";
    }


    @GetMapping("/facebook")
    public String facebook(HttpSession session) {

        Integer count = (Integer) session.getAttribute("facebookCount");
        if (count == null) count = 0;

        session.setAttribute("facebookCount", count + 1);

        return "facebook";
    }


    @GetMapping("/whatsapp")
    public String whatsapp() {
        return "whatsapp";
    }

    @GetMapping("/instagram")
    public String instagram(HttpSession session) {

        Integer count = (Integer) session.getAttribute("instagramCount");
        if (count == null) count = 0;

        session.setAttribute("instagramCount", count + 1);

        return "instagram";
    }

    @GetMapping("/chatbot")
    public String chatbotPage(HttpSession session) {

        Integer count = (Integer) session.getAttribute("chatbotCount");
        if (count == null) count = 0;

        session.setAttribute("chatbotCount", count + 1);

        return "chatbot";
    }

    
    
    @Autowired
    private AIService aiService;

    
    @PostMapping("/chatbot")
    public String chatbotReply(
            @RequestParam String message,
            Model model
    ) {
        String reply = aiService.getAIResponse(message);
        model.addAttribute("reply", reply);
        return "chatbot";
    }

    
    
    
    
    @PostMapping("/command")
    public String handleCommand(@RequestParam String command) {

        String cmd = command.toLowerCase().trim();

        if (cmd.contains("youtube")) return "redirect:/youtube";
        if (cmd.contains("facebook")) return "redirect:/facebook";
        if (cmd.contains("instagram")) return "redirect:/instagram";
        if (cmd.contains("whatsapp")) return "redirect:/whatsapp";
        if (cmd.contains("chatbot") || cmd.contains("ai")) return "redirect:/chatbot";
        if (cmd.contains("dashboard") || cmd.contains("home")) return "redirect:/dashboard";

        return "redirect:/dashboard?error=unknown";
    }

    @GetMapping("/dashboard")
    public String showDashboard(
            @RequestParam(required = false) String error,
            Model model,
            HttpSession session
    ) {

        if ("unknown".equals(error)) {
            model.addAttribute(
                "aiMessage",
                "🤖 Sorry, I didn’t understand that command."
            );
        }

        model.addAttribute("youtubeCount", session.getAttribute("youtubeCount"));
        model.addAttribute("instagramCount", session.getAttribute("instagramCount"));
        model.addAttribute("facebookCount", session.getAttribute("facebookCount"));
        model.addAttribute("chatbotCount", session.getAttribute("chatbotCount"));

        return "dashboard";
    }




    
    
    
    
    
    
   

}
