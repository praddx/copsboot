package com.plahotin.copsboot.service.user;

import com.plahotin.copsboot.model.user.User;
import com.plahotin.copsboot.model.user.UserId;

import java.util.Optional;

public interface UserService {
    User createOfficer(String email, String password);

    Optional<User> getUser(UserId id);
}
