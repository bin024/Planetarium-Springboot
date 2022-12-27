package com.project1.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project1.boot.entities.Moon;

public interface MoonDao extends JpaRepository<Moon, Integer> {
    
    Optional<Moon> findByMoonName(String name);

    @Modifying
    @Transactional
    @Query(value = "insert into moons values(default, :moonName, :myPlanetId)", nativeQuery = true)
    void createMoon(@Param("moonName")String moonName, @Param("myPlanetId")int myPlanetId);


    @Transactional
    @Query(value = ("select * from moons where myPlanetId = :myPlanetId"), nativeQuery = true)
    List<Moon> getMoonsFromPlanet(@Param("myPlanetId")int myPlanetId);
}
