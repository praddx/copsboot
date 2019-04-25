package com.plahotin.copsboot.repository.user;

import com.plahotin.copsboot.model.user.UserId;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final UniqueIdGenerator<UUID> generator;

//    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator) {
//        this.generator = generator;
//    }

    @Override
    public UserId nextId() {
        return new UserId(generator.getNextUniqueId());
    }
}
