package com.masai.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.main.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public Optional<UserEntity> findByEmail(String email);

}
