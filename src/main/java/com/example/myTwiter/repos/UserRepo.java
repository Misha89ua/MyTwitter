package com.example.myTwiter.repos;

import com.example.myTwiter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
