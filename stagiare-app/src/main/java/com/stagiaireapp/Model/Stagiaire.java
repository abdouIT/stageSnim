package com.stagiaireapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Stagiairee")
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nom")
    private String firstname;
    @Column(name = "preNom")
    private String lastname;
    @Column(name = "dateDebut")
    private LocalDate datedeb;
    @Column(name = "dateFin")
    private LocalDate datefin;
    @Column(name = "CIN")
    private Long cin;
    @Column(name = "nTelephone")
    private Long numberphone;
    @Column(name = "nBadge")
    private  Integer nbadge;


    @ManyToOne // Plusieurs Stagiaires peuvent appartenir à un seul département
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @ManyToOne // Plusieurs Stagiaires peuvent appartenir à un seul  Service
    @JoinColumn(name = "service_id")
    private Service service;

}