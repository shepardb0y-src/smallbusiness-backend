package com.fabiobenoit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiobenoit.backend.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	

}
