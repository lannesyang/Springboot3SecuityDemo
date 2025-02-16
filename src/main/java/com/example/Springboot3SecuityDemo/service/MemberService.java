package com.example.Springboot3SecuityDemo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Springboot3SecuityDemo.model.DemoMember;

public interface MemberService extends UserDetailsService{
	
	public int getMaxId(); 
	
	public void saveMember(DemoMember member);
	
	public int checkAccountExist(String account);
}
