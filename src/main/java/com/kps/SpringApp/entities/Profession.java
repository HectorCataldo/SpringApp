package com.kps.SpringApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profession;

    private String profession_Name;

    //Constructores
    public Profession() {
    }

    public Profession(Integer id_profession, String profession_Name) {
        this.id_profession = id_profession;
        this.profession_Name = profession_Name;
    }

    public Integer getId_profession() {
        return id_profession;
    }

    public void setId_profession(Integer id_profession) {
        this.id_profession = id_profession;
    }

    public String getProfession_Name() {
        return profession_Name;
    }

    public void setProfession_Name(String profession_Name) {
        this.profession_Name = profession_Name;
    }
}
