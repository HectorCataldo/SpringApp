package com.kps.SpringApp.repositories;

import com.kps.SpringApp.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession,Integer> {
}
