package com.Sachi.restapis.repository;

import com.Sachi.restapis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
