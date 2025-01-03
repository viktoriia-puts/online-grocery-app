package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Страница /account — только для аутентифицированных
                        .requestMatchers("/account").authenticated()
                        // Все остальные — доступны всем
                        .anyRequest().permitAll()
                )
                // Настраиваем форму логина
                .formLogin(form -> form
                        .loginPage("/login")              // своя страница логина
                        .defaultSuccessUrl("/account", true) // после успешного логина переход на /account
                        .permitAll()                      // страницу логина видят все
                )
                // Логаут (по умолчанию доступен всем)
                .logout(logout -> logout.permitAll())
                // Отключаем CSRF для простоты
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
