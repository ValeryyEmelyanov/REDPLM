package com.pak.redplm.service;

import com.pak.redplm.entity.UserEntity;
import com.pak.redplm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    private BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    public void saveUser(UserEntity userEntity){
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }
}
