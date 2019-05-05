package com.plahotin.copsboot.exceptions.user;

import com.plahotin.copsboot.model.user.UserId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UserId id) {
        super(String.format("Could not find user with id %s", id.asString()));
    }
}
