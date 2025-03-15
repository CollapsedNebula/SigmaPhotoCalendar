package com.sigma.sigmacalendar.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigma.sigmacalendar.model.User;
import com.sigma.sigmacalendar.repository.UserRepository;
import com.sigma.sigmacalendar.request.SignupPostReq;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signup(SignupPostReq request) {
        User user = new User(request.getUserId(), passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }
    
}
