package com.backcrud.backcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backcrud.backcrud.entity.User;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.username=:username, u.email=:email WHERE u.id=:id")
    void updateUser(@Param(value = "id") Integer id, @Param(value = "username") String username, @Param(value = "email") String email);

    // @Query(value = "SELECT * FROM cat_user u WHERE u.email =:email", nativeQuery = true)
    // Optional<User> findByEmail(@Param(value = "email") String email);

    Optional<User> findByEmail(String email);

}
 