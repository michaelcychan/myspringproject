package com.example.mySpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mySpringProject.model.PrimeMinisterModel;

import java.util.List;

@Repository
public interface PrimeMinisterRepository extends JpaRepository<PrimeMinisterModel, Integer> {

    @Query(value = "SELECT * FROM prime_minister pm WHERE pm.year_start_office <= :year AND (pm.year_out_office >= :year OR pm.year_out_office IS NULL)", nativeQuery = true)
    List<PrimeMinisterModel> findPMByYear(@Param("year") int year);
}
