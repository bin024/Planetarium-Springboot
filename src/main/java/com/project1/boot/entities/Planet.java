package com.project1.boot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @Column(name = "id")
    private int planetId;
    @Column(name = "name")
    private String planetName;
    @Column(name = "ownerid")
    private int ownerId;

    
    public int getPlanetId() {
        return planetId;
    }
    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }
    public String getPlanetName() {
        return planetName;
    }
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    @Override
    public String toString() {
        return "User [planetId=" + planetId + ", planetName=" + planetName + ", ownerId=" + ownerId + "]";
    }

    
}
