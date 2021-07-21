package com.plog.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plog.web.domain.UserEntity;
import com.plog.web.respository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public String register(UserDTO userDto) {
		
		UserEntity user = userDto.toEntity();
		
		try {
			if(userRepository.findByEmail(user.getEmail()) != null) {
				return "EXIST";
			}
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
		
		return "SUCCESS";
	}

}
