package com.project1.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.boot.entities.Planet;
import com.project1.boot.exceptions.EntityNotFound;
import com.project1.boot.repository.PlanetDao;

@Service
public class PlanetService {
    
    @Autowired
    private PlanetDao planetDao;

    public Planet getMyPlanetId(int id){
        Optional<Planet> possiblePlanet = this.planetDao.findById(id);
        if(possiblePlanet.isPresent()){
            return possiblePlanet.get();
        }else{
            throw new EntityNotFound("Planet not found");
        }
    }

    public Planet getPlanetByName(String name){
        Optional<Planet> possiblePlanet = this.planetDao.findByPlanetName(name);
        if(possiblePlanet.isPresent()){
            return possiblePlanet.get();
        }else{
            throw new EntityNotFound("Planet not found");
        }
    }

    public List<Planet> getAllPlanets(){
        List<Planet> planets = this.planetDao.findAll();
        if(planets.size() != 0){
            return planets;
        }else {
            throw new EntityNotFound("No planets were found");
        }
    }

    public String createPlanet(Planet planet){
        this.planetDao.createPlanet(planet.getPlanetName(), planet.getOwnerId());
        return "Planet created";
    }

    public String deletePlanetById(int id){
        this.planetDao.deleteById(id);
        return "Planet with given id deleted";
    }
}
