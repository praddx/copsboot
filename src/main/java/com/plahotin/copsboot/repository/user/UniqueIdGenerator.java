package com.plahotin.copsboot.repository.user;

public interface UniqueIdGenerator<T> {

    T getNextUniqueId();
}
