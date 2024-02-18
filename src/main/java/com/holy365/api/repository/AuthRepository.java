package com.holy365.api.repository;


import com.holy365.api.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

  Optional<Auth> findByIdentity(String identity);
}
