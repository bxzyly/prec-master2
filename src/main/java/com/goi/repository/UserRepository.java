package com.goi.repository;

import com.goi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    public User findByUsername(String username);

    public User findByTelephone(String telephone);
}
