package com.poly.myapp.model.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.poly.myapp.config.jwt.CUserNotFoundException;
import com.poly.myapp.model.dao.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService{

	private  MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userPk) {

        return (UserDetails) memberMapper.findById(Long.valueOf(userPk));
        
	}
    }