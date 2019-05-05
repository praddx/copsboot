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
@NoArgsConstructor
public class User extends AbstractEntity<UserId> {

    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    public User(@NonNull UserId id, String email, String password, @NotNull Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public static User createOfficer(UserId id, String email, String password) {
        Set<UserRole> role = new HashSet<>();
        role.add(UserRole.OFFICER);
        return new User(id, email, password, role);
    }

    public static User createCaptain(UserId id, String email, String password) {
        Set<UserRole> role = new HashSet<>();
        role.add(UserRole.CAPTAIN);
        return new User(id, email, password, role);
    }

}
