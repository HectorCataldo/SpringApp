package com.kps.SpringApp.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String secondLastName;
    private LocalDate birthDate;
    private String gender;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_profession")
    private Profession profession;

    private Boolean state;


    public Client() {
    }

    public Client(Integer id,
                  String documentNumber,
                  String firstName,
                  String lastName,
                  String secondLastName,
                  LocalDate birthDate,
                  String gender,
                  String nationality,
                  String phoneNumber,
                  String email,
                  String address,
                  Profession profession,
                  Boolean state) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.profession = profession;
        this.state = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Boolean getState() {return state;}

    public void setState(Boolean state) {this.state = state;}

    public String getSecondLastName() {return secondLastName;}

    public void setSecondLastName(String secondLastName) {this.secondLastName = secondLastName;}
}



