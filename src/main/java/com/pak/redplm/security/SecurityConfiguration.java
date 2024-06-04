package com.pak.redplm.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/registration").permitAll()
                .anyRequest().authenticated())
                .formLogin((form)->form.loginPage("/login").permitAll())
                .logout((logout)->logout.permitAll());

        return http.build();
    }
}

//                .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                .requestMatchers("/api/users/**").hasAnyRole("ADMIN", "SUPERVISOR")
//                .requestMatchers("/api/assembly-units/**").hasAnyRole("ADMIN", "WORKER", "SUPERVISOR")
//                .requestMatchers("/api/details/**").hasAnyRole("ADMIN", "WORKER", "SUPERVISOR")
//                .requestMatchers("/api/instructions/**").hasAnyRole("ADMIN", "WORKER", "SUPERVISOR")
