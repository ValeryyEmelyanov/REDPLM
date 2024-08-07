package com.pak.redplm.service;

import com.pak.redplm.entity.UserEntity;
import com.pak.redplm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userEntityRepository;

    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userEntityRepository.save(userEntity);
    }

    public Optional<UserEntity> findById(Long id) {
        return userEntityRepository.findById(id);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return userEntityRepository.findByEmail(email);
    }

    public void updateUser(UserEntity userEntity) {
        userEntityRepository.save(userEntity);
    }

    public void deleteUserById(Long id) {
        userEntityRepository.deleteById(id);
    }

    public void deleteByEmail(String email) {
        userEntityRepository.deleteByEmail(email);
    }

    public List<UserEntity> findAllUsers() {
        return userEntityRepository.findAll();
    }

    public boolean existsByEmail(String email) {
        return userEntityRepository.existsByEmail(email);
    }



}
