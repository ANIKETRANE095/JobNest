package com.JobNest.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.JobNest.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // For login / checking if email exists
    Optional<User> findByEmail(String email);
}
