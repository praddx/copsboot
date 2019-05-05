package com.plahotin.copsboot.model.user;

import lombok.Value;

import java.util.Set;

@Value
public class UserDto {

    private final UserId id;
    private final String email;
    private final Set<UserRole> roles;

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getRoles());
    }
}
