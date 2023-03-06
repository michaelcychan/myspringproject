package com.example.mySpringProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prime_minister")
public class PrimeMinisterModel {
    private int id;
    private String name;
    private int yearOfBirth;
    private Integer yearOfDeath;
    private int yearStartOffice;
    private Integer yearOutOffice;
    private String party;

    public PrimeMinisterModel() {
    }

    public PrimeMinisterModel(int id, String name, int yearOfBirth, Integer yearOfDeath, int yearStartOffice, Integer yearOutOffice, String party) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.yearStartOffice = yearStartOffice;
        this.yearOutOffice = yearOutOffice;
    }

    @Id
    @Column(name="id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int newID) {
        this.id = newID;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    @Column (name="year_of_birth")
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int newYear) {
        this.yearOfBirth = newYear;
    }

    @Column (name="year_of_death")
    public Integer getYearOfDeath() {
        return yearOfDeath;
    }
    public void setYearOfDeath(Integer newYoD) {
        this.yearOfDeath = newYoD;
    }

    @Column (name="year_start_office")
    public int getYearStartOffice() {
        return yearStartOffice;
    }
    public void setYearStartOffice(int newYSO) {
        this.yearStartOffice = newYSO;
    }

    @Column (name="year_out_office")
    public Integer getYearOutOffice() {
        return yearOutOffice;
    }
    public void setYearOutOffice(Integer newYOO) {
        this.yearOutOffice = newYOO;
    }

    @Column(name="party")
    public String getParty(){
        return party;
    }
    public void setParty(String newParty) {
        this.party = newParty;
    }
}
