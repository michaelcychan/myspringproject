package com.example.mySpringProject.model;

import jakarta.persistence.*;

@Entity
@Table(name="monarch")
public class MonarchModel{

    private String name;
    private int yearOfBirth;
    private Integer yearOfDeath;
    private int yearOfReignStart;
    private Integer yearOfReignEnd;

    public MonarchModel() {
    }

    public MonarchModel(String name, int yearOfBirth, int yearOfDeath, int yearOfReignStart, int yearOfReignEnd) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.yearOfReignStart = yearOfReignStart;
        this.yearOfReignEnd = yearOfReignEnd;
    }

    @Id
    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    @Column(name="year_of_birth")
    public Integer getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(Integer newYoB){
        this.yearOfBirth = newYoB;
    }

    @Column(name="year_of_death", nullable=true)
    public Integer getYearOfDeath() {
        return yearOfDeath;
    }
    public void setYearOfDeath(Integer newYoD){
        this.yearOfDeath = newYoD;
    }

    @Column(name="year_of_reign_start", nullable=true)
    public Integer getYearOfReignStart() {
        return yearOfReignStart;
    }
    public void setYearOfReignStart(Integer newYoRS) {
        this.yearOfReignStart = newYoRS;
    }

    @Column(name="year_of_reign_end")
    public Integer getYearOfReignEnd() {
        return  yearOfReignEnd;
    }
    public void setYearOfReignEnd(Integer newYoRE){
        this.yearOfReignEnd = newYoRE;
    }

}
