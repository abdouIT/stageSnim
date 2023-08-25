package com.stagiaireapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nomDepartemnt")
    private  String nomdepartement;

    @Column(name = "nomdirection")
    private  String nomdirection;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;
}

