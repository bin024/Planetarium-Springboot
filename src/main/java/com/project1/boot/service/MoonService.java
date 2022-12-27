package com.project1.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.boot.entities.Moon;
import com.project1.boot.exceptions.EntityNotFound;
import com.project1.boot.repository.MoonDao;

@Service
public class MoonService {
    
    @Autowired
    private MoonDao moonDao;

    public Moon getMoonById(int id){
        Optional<Moon> possibleMoon = this.moonDao.findById(id);
        if(possibleMoon.isPresent()){
            return possibleMoon.get();
        }else{
            throw new EntityNotFound("Moon not found");
        }
    }

    public Moon getMoonByName(String name){
        Optional<Moon> possibleMoon = this.moonDao.findByMoonName(name);
        if(possibleMoon.isPresent()){
            return possibleMoon.get();
        }else{
            throw new EntityNotFound("Moon not found");
        }
    }

    public List<Moon> getAllMoons(){
        List<Moon> moons = this.moonDao.findAll();
        if(moons.size() != 0){
            return moons;
        }else {
            throw new EntityNotFound("No moons were found");
        }
    }

    public String createMoon(Moon moon){
        this.moonDao.createMoon(moon.getMoonName(), moon.getMyPlanetId());
        return "Moon created";
    }

    public String deleteMoonById(int id){
        this.moonDao.deleteById(id);
        return "Moon with given id deleted";
    }

    public List<Moon> getMoonsFromPlanets(int planetId){
        List<Moon> moons = this.moonDao.getMoonsFromPlanet(planetId);
        if(moons.size() != 0){
            return moons;
        }else {
            throw new EntityNotFound("No moons were found");
        }
    }
}
