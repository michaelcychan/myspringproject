package com.example.mySpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mySpringProject.model.MonarchModel;

import java.util.List;

@Repository
public interface MonarchRepository extends JpaRepository<MonarchModel, String> {

    @Query(value = "SELECT * FROM monarch m WHERE m.year_of_reign_start <= :year AND (m.year_of_reign_end >= :year OR m.year_of_reign_end IS null)", nativeQuery = true)
    List<MonarchModel> findMonarchByYear(@Param("year") int year);

    @Query(value = "SELECT * FROM monarch m WHERE m.name = :name", nativeQuery = true)
    MonarchModel getMonarchByName(@Param("name") String name);
}
