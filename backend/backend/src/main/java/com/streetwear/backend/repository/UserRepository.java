package com.streetwear.backend.repository;

import com.streetwear.backend.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

}
