package com.schoolproj2.schoolproj2.repository;

import java.util.Optional;

import com.schoolproj2.schoolproj2.entity.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

	Optional<Client> findById(Long id);

}
