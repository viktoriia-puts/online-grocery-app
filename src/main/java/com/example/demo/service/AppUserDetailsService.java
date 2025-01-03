package com.example.demo.service;

import com.example.demo.model.Register;
import com.example.demo.repository.RegisterRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final RegisterRepository registerRepository;

    public AppUserDetailsService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Register user = registerRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // уже хешированный
                .roles("USER")
                .build();
    }
}

