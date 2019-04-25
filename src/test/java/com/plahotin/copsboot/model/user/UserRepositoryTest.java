package com.plahotin.copsboot.model.user;

import com.plahotin.copsboot.repository.user.UserRepository;
import lombok.val;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void storeUserTest() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(UUID.randomUUID(),
                "John Smith", "john@mail.com", "my-pass", roles));

        assertThat(user).isNotNull();

        assertThat(repository.count()).isEqualTo(1L);
    }
}
