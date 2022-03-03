package com.fabiobenoit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiobenoit.backend.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
