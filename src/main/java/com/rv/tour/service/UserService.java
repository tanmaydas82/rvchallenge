package com.rv.tour.service;

import com.rv.tour.domain.User;
import com.rv.tour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Tdas on 11/29/15.
 */
public interface UserService {
    User findUserByUserName(String userName);
}
