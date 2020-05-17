package com.halen.springboot.repository;

import com.halen.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Halen 2020/5/17 19:32
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
