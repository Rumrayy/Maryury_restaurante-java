package com.unicaes.TheBBQPlace.persistence.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.SplittableRandom;

public class ReserveDetailsImpl implements UserDetails {

    private ReserveEntity reserve;
    private ClientEntity client;

    public ReserveDetailsImpl(ReserveEntity reserve, ClientEntity client){
        this.reserve = reserve;
        this.client = client;
    }

    public String getName(){
        return  client.getName();
    }

    public String getArea(){
        return  reserve.getArea();
    }
    public Date getDate(){
        return  reserve.getDate();
    }
    public LocalTime getHour(){
        return  reserve.getHour();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
