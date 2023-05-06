package com.ecommerce.user.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetail implements UserDetails {

    private final User myUser;

    public MyUserDetail(User myUser) {
        this.myUser = myUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(myUser.getRole());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return myUser.getPassword();
    }

    @Override
    public String getUsername() {
        return myUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
