package com.rv.tour.service;

import com.rv.tour.domain.User;
import com.rv.tour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Tdas on 11/29/15.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long userId) {
        return null;
    }
}
