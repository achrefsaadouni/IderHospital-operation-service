package com.example.gestion_operation.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class OperationView  implements Serializable {

    private static final long serialVersionUID = 6;
    @Id
    @GeneratedValue
    private int id;
    private Date date_operation;
    private String nom_operation;
    private OperatingRoom room;
    private Patient patient;
    private Personnel docteur;

    public Personnel getDocteur() {
        return docteur;
    }

    public void setDocteur(Personnel docteur) {
        this.docteur = docteur;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_operation() {
        return date_operation;
    }

    public void setDate_operation(Date date_operation) {
        this.date_operation = date_operation;
    }

    public String getNom_operation() {
        return nom_operation;
    }

    public void setNom_operation(String nom_operation) {
        this.nom_operation = nom_operation;
    }

    public OperatingRoom getRoom() {
        return room;
    }

    public void setRoom(OperatingRoom room) {
        this.room = room;
    }

    public OperationView(Operation op , OperatingRoom opr ,Patient p,Personnel docteur) {
        this.date_operation = op.getDate_operation();
        this.nom_operation = op.getNom_operation();
        this.room = opr;
        this.patient = p;
        this.docteur = docteur;
    }
}
