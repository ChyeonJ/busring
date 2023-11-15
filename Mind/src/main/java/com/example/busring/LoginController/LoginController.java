package com.example.busring.LoginController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf 템플릿 이름
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // 여기서 사용자 인증을 수행하고 로그인 성공 또는 실패에 따라 적절한 처리를 수행합니다.
        // 실제 사용자 데이터베이스나 인증 서비스를 사용하게 될 것입니다.

        if (isValidUser(username, password)) {
            model.addAttribute("message", "로그인 성공!");
        } else {
            model.addAttribute("message", "로그인 실패!");
        }

        return "result"; // 로그인 결과를 보여주는 템플릿 이름
    }

    private boolean isValidUser(String username, String password) {
        // 실제 사용자 인증 로직을 구현해야 합니다.
        // 여기서는 간단한 예제를 위해 하드 코딩하였습니다.
        return "user".equals(username) && "password".equals(password);
    }
}
