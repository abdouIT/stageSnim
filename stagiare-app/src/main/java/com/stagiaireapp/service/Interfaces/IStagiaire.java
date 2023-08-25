package com.stagiaireapp.service.Interfaces;

import com.stagiaireapp.Model.Stagiaire;

import java.util.List;
import java.util.UUID;

public interface IStagiaire {
    public List<Stagiaire> getAllStagiaire();

    public Stagiaire saveStagiaire(Stagiaire stagiaire);
    public Stagiaire getStagiaireById(UUID id);
    public Stagiaire updateStagiaire(UUID id, Stagiaire stagiaire);
    public void deleteStagiaire(UUID id);
}
