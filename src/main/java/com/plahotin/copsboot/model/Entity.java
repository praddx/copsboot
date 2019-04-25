package com.plahotin.copsboot.model;

import java.io.Serializable;

public interface Entity<T extends EntityId> {

    T getId();
}
