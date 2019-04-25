package com.plahotin.copsboot.model;

import java.io.Serializable;

public interface EntityId<T> extends Serializable {

    T getId();

    String asString();
}
