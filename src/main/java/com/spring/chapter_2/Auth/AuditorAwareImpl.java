package com.spring.chapter_2.Auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //get security context
        //get authentication
        //get the principle
        //get the username
        return Optional.of("Srijan Chandra");
    }
}
