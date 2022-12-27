package com.project1.boot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moons")
public class Moon {
    @Id
    @Column(name = "id")
    private int moonId;
    @Column(name = "name")
    private String moonName;
    @Column(name = "myplanetid")
    private int myPlanetId;
    
    public int getMoonId() {
        return moonId;
    }
    public void setMoonId(int moonId) {
        this.moonId = moonId;
    }
    public String getMoonName() {
        return moonName;
    }
    public void setMoonName(String moonName) {
        this.moonName = moonName;
    }
    public int getMyPlanetId() {
        return myPlanetId;
    }
    public void setMyPlanetId(int myPlanetId) {
        this.myPlanetId = myPlanetId;
    }
    @Override
    public String toString() {
        return "Moon [moonId=" + moonId + ", moonName=" + moonName + ", myPlanetId=" + myPlanetId + "]";
    }
    
   

    
}