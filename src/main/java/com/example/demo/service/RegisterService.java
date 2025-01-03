package com.example.demo.service;

import com.example.demo.model.Register;
import com.example.demo.repository.RegisterRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final RegisterRepository registerRepository;
    private final PasswordEncoder passwordEncoder;


    public RegisterService(RegisterRepository registerRepository, PasswordEncoder passwordEncoder) {
        this.registerRepository = registerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Register saveRegister(Register register) {
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        return registerRepository.save(register);
    }
}
