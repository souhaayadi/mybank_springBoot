package com.projet.dao;


import com.projet.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLoginAndPassword(String login,String password);
}
