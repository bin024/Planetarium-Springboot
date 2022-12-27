package com.project1.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project1.boot.entities.Planet;

public interface PlanetDao extends JpaRepository<Planet, Integer> {
    
    Optional<Planet> findByPlanetName(String name);

    @Modifying
    @Transactional
    @Query(value = "insert into planets values(default, :planetName, :ownerId)", nativeQuery = true)
    void createPlanet(@Param("planetName")String planetName, @Param("ownerId")int ownerId);

    // @Modifying
    // @Transactional
    // @Query(value = "update planets set name = :planetName, ownerId = :ownerId where id = id", nativeQuery = true)
    // int updatePlanet(@Param("planetName")String planetName, @Param("ownerId")int ownerId, @Param("id")int id);
}
