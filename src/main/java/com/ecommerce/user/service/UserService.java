package com.ecommerce.user.service;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public void insert(User user) {
        userRepo.save(user);
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        userRepo.deleteById(user.getId());
    }

    @Override
    public User findTheUser(User user) {
        return userRepo.findUserById(user.getId());
    }

    @Override
    public List<User> allUser() {
        return userRepo.findAll();
    }

    @Override
    public List<User> allUserPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable).getContent();
    }

}
