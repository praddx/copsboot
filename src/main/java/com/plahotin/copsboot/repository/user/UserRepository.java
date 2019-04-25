package com.plahotin.copsboot.repository.user;

import com.plahotin.copsboot.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {


}
