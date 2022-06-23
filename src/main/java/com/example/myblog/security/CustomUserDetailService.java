package com.example.myblog.security;

import com.example.myblog.exception.ResourceNotFoundException;
import com.example.myblog.model.entity.User;
import com.example.myblog.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> new ResourceNotFoundException("User", "email" + username, 0)
        );

        return user;
    }
}
