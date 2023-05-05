package com.ecommerce.user.repo;

import com.ecommerce.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findUserByUsername(String username);
}
