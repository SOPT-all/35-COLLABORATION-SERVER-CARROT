package com.sopt.carrot_server.app.domain.repository;

import com.sopt.carrot_server.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
