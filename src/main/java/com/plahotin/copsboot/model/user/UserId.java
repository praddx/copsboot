package com.plahotin.copsboot.model.user;

import com.plahotin.copsboot.model.AbstractEntity;
import com.plahotin.copsboot.model.AbstractEntityId;

import java.util.UUID;

public class UserId extends AbstractEntityId<UUID> {

    protected UserId() {

    }

    public UserId(UUID id) {
        super(id);
    }

    public static UserId from(UUID uuid) {
        return new UserId(uuid);
    }
}
