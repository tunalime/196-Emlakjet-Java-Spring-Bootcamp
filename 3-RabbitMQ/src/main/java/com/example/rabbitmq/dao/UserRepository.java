package com.example.rabbitmq.dao;
import com.example.rabbitmq.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users getByEmail(String email);

}
