package com.plahotin.copsboot.model.user;

import com.plahotin.copsboot.model.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "copsboot_user")
@Data
public class User extends AbstractEntity<UserId> {

    private String name;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    public User(@NonNull UserId id, String name, String email, String password, @NotNull Set<UserRole> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
