package br.com.portability.controller;

import br.com.portability.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stringtemplate.v4.ST;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public String generateToken(@RequestBody Map<String, String> body) {
        String clientId = body.get("clientId");
        return jwtUtil.generateToken(body.get("clientId"));
    }
}
