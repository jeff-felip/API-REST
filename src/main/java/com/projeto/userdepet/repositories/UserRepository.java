package com.projeto.userdepet.repositories;

import com.projeto.userdepet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}