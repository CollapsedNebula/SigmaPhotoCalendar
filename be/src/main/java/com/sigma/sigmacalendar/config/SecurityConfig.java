package com.sigma.sigmacalendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/signup").permitAll()  // 루트 페이지는 모든 사용자 접근 가능
                .requestMatchers("/api/login").permitAll()  // 루트 페이지는 모든 사용자 접근 가능
                .anyRequest().authenticated()  // 나머지는 로그인 필요
            )
            .formLogin(login -> login.disable()) // 기본 로그인 폼 비활성화
            .csrf(csrf -> csrf.disable()); // CSRF 보안 설정 비활성화 (테스트용)
        
        return http.build();
    }

    //  비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


