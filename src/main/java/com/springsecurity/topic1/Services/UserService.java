package com.springsecurity.topic1.Services;

import com.springsecurity.topic1.Entities.UserEntity;
import com.springsecurity.topic1.Exceptions.ResourceNotFoundException;
import com.springsecurity.topic1.IServices.IUserService;
import com.springsecurity.topic1.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//if commenting @service "Global AuthenticationManager configured with UserDetailsService bean with name inMemoryUserDetailsManager"
//otherwise if using @service "Global AuthenticationManager configured with UserDetailsService bean with name userservice"
@RequiredArgsConstructor
public class UserService implements IUserService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException(" Username "+ username + "not found"));
    }
}
