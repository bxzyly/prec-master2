package com.goi.repository;

import com.goi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    User findByTelephone(String telephone);

}
