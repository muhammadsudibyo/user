package com.ecommerce.user.controller;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repo.UserRepo;
import com.ecommerce.user.util.AccountNumberGenerator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("user")
public class RestUserController {
    @Autowired
    UserRepo userRepo;

    //Get ALl User
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(){ return userRepo.findAll();
    }

    //Get by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable("id") int id){ return userRepo.findUserById(id);
    }

    //tambah get by Username
    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserByUsername(@PathVariable("username") String username){ return userRepo.findUserByUsername(username);
    }

    //Add User
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public User addUser(@RequestBody User user){
        String temp = AccountNumberGenerator.generate();
        String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashPassword);
        user.setAccountNo(temp);
        user.setDeleteFlag("N");
        user.setRole("user");
        user.setEnabled(true);
        return userRepo.save(user);
    }

    @PostMapping("/addAdmin")
    @ResponseStatus(HttpStatus.OK)
    public User addAdmin(@RequestBody User user){
        String temp = AccountNumberGenerator.generate();
        String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashPassword);
        user.setAccountNo(temp);
        user.setDeleteFlag("N");
        user.setRole("user");
        user.setEnabled(true);
        return userRepo.save(user);
    }

    //
    @PutMapping("/update/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user, @PathVariable("username") String username){
        User existUser = userRepo.findUserByUsername(username);

        existUser.setName(user.getName());
        existUser.setAlamat(user.getAlamat());

        return userRepo.save(existUser);
    }

    //topup
    @PutMapping("/topup/{username}+{saldo}")
    @ResponseStatus(HttpStatus.OK)
    public User topSaldoUser(@PathVariable("username") String username, @PathVariable("saldo") BigDecimal saldo){
        User existUser = userRepo.findUserByUsername(username);
        if(existUser != null){
            existUser.setBalance(existUser.getBalance().add(saldo));
            return userRepo.save(existUser);
        }else{
            return null;
        }
    }

    //Soft delete
    @PutMapping("/delete/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void softDeleteUser(@PathVariable("username") String username){
        User existUser = userRepo.findUserByUsername(username);
        if(existUser != null){
            existUser.setDeleteFlag("Y");
            userRepo.save(existUser);
        }
    }

    @DeleteMapping("/hard/delete/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("username") String username){
        User existUser = userRepo.findUserByUsername(username);
        if(existUser != null && existUser.getDeleteFlag().equals("Y")){
            userRepo.deleteById(existUser.getId());
        }
    }

}
