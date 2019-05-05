package com.plahotin.copsboot.controller.user;

import com.plahotin.copsboot.exceptions.user.UserNotFoundException;
import com.plahotin.copsboot.model.user.User;
import com.plahotin.copsboot.model.user.UserDto;
import com.plahotin.copsboot.repository.user.UserRepository;
import com.plahotin.copsboot.security.ApplicationUserDetails;
import com.plahotin.copsboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserDto currentUser(@AuthenticationPrincipal ApplicationUserDetails userDetails) {
        User user = userService.getUser(userDetails.getUserId()).orElseThrow(() -> new UserNotFoundException(userDetails.getUserId()));
        return UserDto.from(user);
    }


}
