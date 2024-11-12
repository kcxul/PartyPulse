package com.group9.partypulse.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

    void deleteUserById(int id);

    @Query(value = "SELECT * FROM user WHERE id = :id",nativeQuery = true)
    Optional<User> findUserByID(int user_id);}
