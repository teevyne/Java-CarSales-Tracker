package com.cardatabase.CarDatabase.repository;

import com.cardatabase.CarDatabase.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByFirstName(String firstName);
}
