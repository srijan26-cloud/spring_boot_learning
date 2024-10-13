package com.springsecurity.topic1.Configurations;

import ch.qos.logback.core.encoder.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    //Generally used for testing, InMemoryUserDetailsManager
    @Bean
    UserDetailsService myInMemoryUserDetailsService(){
        UserDetails normalUser = User
                .withUsername("srijan")
                .password(passwordEncoder().encode("srijan123"))
                .roles("USER")
                .build();

        UserDetails adminUser = User
                .withUsername("sriji")
                .password(passwordEncoder().encode("sriji123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser , adminUser);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}
