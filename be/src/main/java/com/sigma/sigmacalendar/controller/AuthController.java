package com.sigma.sigmacalendar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sigma.sigmacalendar.request.LoginPostReq;
import com.sigma.sigmacalendar.request.SignupPostReq;
import com.sigma.sigmacalendar.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Validated @RequestBody SignupPostReq request) {
        log.info("request: {}", request);
        userService.signup(request);
        return ResponseEntity.ok("회원가입 성공!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody LoginPostReq request) {
        log.info("request: {}", request);
        userService.login(request);
        return ResponseEntity.ok("로그인 성공!");
    }
}