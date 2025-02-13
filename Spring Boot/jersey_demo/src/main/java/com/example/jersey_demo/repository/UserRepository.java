package com.example.jersey_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jersey_demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
