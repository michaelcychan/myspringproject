package com.example.mySpringProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.JoinFormula;

@Entity
@Table(name="prime_minister")
public class PrimeMinisterModel {
    @Id
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="appointed_by")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MonarchModel mon;

    @Column (name="year_of_birth")
    private int yearOfBirth;

    @Column (name="year_of_death")
    private Integer yearOfDeath;

    @Column (name="year_start_office")
    private int yearStartOffice;

    @Column (name="year_out_office")
    private Integer yearOutOffice;

    @Column(name="party")
    private String party;

    public PrimeMinisterModel() {
    }

    public PrimeMinisterModel(int id, String name, MonarchModel mon, int yearOfBirth, Integer yearOfDeath, int yearStartOffice, Integer yearOutOffice, String party) {
        this.id = id;
        this.name = name;
        this.mon = mon;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.yearStartOffice = yearStartOffice;
        this.yearOutOffice = yearOutOffice;
    }

    public int getId() {
        return id;
    }
    public void setId(int newID) {
        this.id = newID;
    }


    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public MonarchModel getMon(){
        return mon;
    }
    public void setMon(MonarchModel mon){
        this.mon = mon;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int newYear) {
        this.yearOfBirth = newYear;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }
    public void setYearOfDeath(Integer newYoD) {
        this.yearOfDeath = newYoD;
    }

    public int getYearStartOffice() {
        return yearStartOffice;
    }
    public void setYearStartOffice(int newYSO) {
        this.yearStartOffice = newYSO;
    }


    public Integer getYearOutOffice() {
        return yearOutOffice;
    }
    public void setYearOutOffice(Integer newYOO) {
        this.yearOutOffice = newYOO;
    }


    public String getParty(){
        return party;
    }
    public void setParty(String newParty) {
        this.party = newParty;
    }
}
