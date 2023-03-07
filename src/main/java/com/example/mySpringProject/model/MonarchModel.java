package com.example.mySpringProject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="monarch")
public class MonarchModel{

    @Id
    @Column(name="name")
    private String name;

    @Column(name="year_of_birth")
    private int yearOfBirth;

    @Column(name="year_of_death", nullable=true)
    private Integer yearOfDeath;

    @Column(name="year_of_reign_start")
    private int yearOfReignStart;

    @Column(name="year_of_reign_end", nullable=true)
    private Integer yearOfReignEnd;

    @OneToMany(mappedBy = "mon", fetch = FetchType.EAGER)
    private List<PrimeMinisterModel> primeMinisterModels;

    public MonarchModel() {
    }

    public MonarchModel(String name, int yearOfBirth, int yearOfDeath, int yearOfReignStart, int yearOfReignEnd) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.yearOfReignStart = yearOfReignStart;
        this.yearOfReignEnd = yearOfReignEnd;
    }


    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }


    public Integer getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(Integer newYoB){
        this.yearOfBirth = newYoB;
    }


    public Integer getYearOfDeath() {
        return yearOfDeath;
    }
    public void setYearOfDeath(Integer newYoD){
        this.yearOfDeath = newYoD;
    }

    public Integer getYearOfReignStart() {
        return yearOfReignStart;
    }
    public void setYearOfReignStart(Integer newYoRS) {
        this.yearOfReignStart = newYoRS;
    }

    public Integer getYearOfReignEnd() {
        return  yearOfReignEnd;
    }
    public void setYearOfReignEnd(Integer newYoRE){
        this.yearOfReignEnd = newYoRE;
    }

}
