package com.group9.partypulse.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Find an admin by their username (for login functionality)
    Optional<Admin> findByUsername(String username);

    // Find admins by their account status
    List<Admin> findByAccountStatus(String accountStatus);  // Query by account status

    // Find admin by id (already covered by JpaRepository)
    // Optional<Admin> findById(Long id);
}
