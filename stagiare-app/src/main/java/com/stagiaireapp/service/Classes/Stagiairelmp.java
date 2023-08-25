package com.stagiaireapp.service.Classes;

import com.stagiaireapp.Model.Stagiaire;
import com.stagiaireapp.Repository.StagiaireRepository;
import com.stagiaireapp.service.Interfaces.IStagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class Stagiairelmp implements IStagiaire {
    @Autowired
    private StagiaireRepository stagiaireRepository;
    @Override
    public List<Stagiaire> getAllStagiaire(){
        return stagiaireRepository.findAll();
    }
    @Override
    public Stagiaire saveStagiaire(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }

    @Override
    public Stagiaire getStagiaireById(UUID id) {
        return stagiaireRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
    }

    @Override
    public Stagiaire updateStagiaire(UUID id, Stagiaire stagiaire) {
        Stagiaire existingStagiaire = stagiaireRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        // Update fields in existingStagiaire

        return stagiaireRepository.save(existingStagiaire);
    }

    @Override
    public void deleteStagiaire(UUID id) {
        stagiaireRepository.deleteById(id);
    }
}
