package com.group9.partypulse.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
    List<Admin> findByAccountStatus(String accountStatus);  // Add this for querying by account status
}