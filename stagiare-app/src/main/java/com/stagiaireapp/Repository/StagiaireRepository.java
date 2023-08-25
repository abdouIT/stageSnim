package com.stagiaireapp.Repository;

import com.stagiaireapp.Model.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StagiaireRepository extends JpaRepository<Stagiaire, UUID> {
    // All commend on Crud
}