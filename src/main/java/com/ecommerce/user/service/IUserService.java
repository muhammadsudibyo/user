package com.ecommerce.user.service;

import com.ecommerce.user.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface IUserService {
    void insert(User user);
    void update(User user);
    void delete(User user);
    User findTheUser(User user);
    List<User> allUser();
    List<User> allUserPage(int page, int size);
}
