package com.ecommerce.user.service;

import com.ecommerce.user.model.MyUserDetail;
import com.ecommerce.user.model.User;
import com.ecommerce.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No User Found");
        }else if (user.getDeleteFlag().equals("Y")){
            throw new UsernameNotFoundException("No User Found");
        }else {
            return new MyUserDetail(user);
        }
    }
}
