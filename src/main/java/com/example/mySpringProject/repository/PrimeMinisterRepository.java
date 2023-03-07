package com.example.mySpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mySpringProject.model.PrimeMinisterModel;

import java.util.List;

@Repository
public interface PrimeMinisterRepository extends JpaRepository<PrimeMinisterModel, Integer> {

    @Query(value="SELECT p.* FROM prime_minister p WHERE p.appointed_by = :monarch", nativeQuery = true)
    List<PrimeMinisterModel> findPMByMonarch(@Param("monarch") String monarch);

    @Query(value = "SELECT * FROM prime_minister WHERE year_start_office <= :year AND (year_out_office >= :year OR year_out_office IS NULL)", nativeQuery = true)
    List<PrimeMinisterModel> findPMByYear(@Param("year") int year);

    @Query(value = "SELECT * FROM prime_minister ORDER BY year_start_office DESC, year_out_office DESC LIMIT 1", nativeQuery = true)
    PrimeMinisterModel getLatestPM();
}
