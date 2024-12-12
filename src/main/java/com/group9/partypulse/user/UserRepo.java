package com.group9.partypulse.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    // Custom query to search users by userName containing a substring
    List<User> findByUserNameContaining(String userName);
}
