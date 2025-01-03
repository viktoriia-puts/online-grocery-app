package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    // Внедряем именно AccountRepository
    public AppUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Ищем аккаунт по username
        Optional<Account> optionalAccount = accountRepository.findByUsername(username);
        if (optionalAccount.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        Account account = optionalAccount.get();

        // Строим объект UserDetails с данными из аккаунта
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword()) // уже зашифрованный пароль
                .roles("USER") // Можно подставить вашу роль
                .build();
    }
}

