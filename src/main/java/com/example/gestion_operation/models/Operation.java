package com.example.gestion_operation.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Operation  implements Serializable {

    private static final long serialVersionUID = 6;
    @Id
    @GeneratedValue
    private int id;
    private Date date_operation;
    private String nom_operation;
    private int patientId;
    private int roomId;
    private int doctorId;

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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }


    public Operation(Date date_operation, String nom_operation, int patientId, int roomId, int doctorId, List<Integer> infirmiers) {
        super();
        this.date_operation = date_operation;
        this.nom_operation = nom_operation;
        this.patientId = patientId;
        this.roomId = roomId;
        this.doctorId = doctorId;
    }

    public Operation() {
        super();
    }
}
