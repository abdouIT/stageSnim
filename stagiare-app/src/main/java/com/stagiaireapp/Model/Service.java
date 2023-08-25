package com.stagiaireapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomService")
    private String nomservice;

    @Column(name = "nomDepartement")
    private String nomdepartement;


    @ManyToOne // De nombreux services peuvent appartenir à un seul département
    @JoinColumn(name = "departement_id")
    private Departement departement;
}