package com.bankingSystem.Baking_Backend.userRepositoryy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingSystem.Baking_Backend.Entityy.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>  {
    Optional<Login> findByEmail(String email);


}
