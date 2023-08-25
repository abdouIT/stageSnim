package com.stagiaireapp.Controller;

import com.stagiaireapp.Repository.StagiaireRepository;
import com.stagiaireapp.service.Classes.Stagiairelmp;
import com.stagiaireapp.service.Interfaces.IStagiaire;
import com.stagiaireapp.Model.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/Stagiaire")
public class StagiaireController {
    @Autowired
    private StagiaireRepository stagiaireRepository;

    @Autowired
    private IStagiaire iStagiaire;
    @Autowired
    private Stagiairelmp stagiairelmp;

    /**
     * endpoint: pour lister les stagiaires
     * @return
     */
    @GetMapping

    public List<Stagiaire> gettAllStagiaire() {
        return iStagiaire.getAllStagiaire();
    }

    /**
     * endpoint: pour create les stagiaires
     * @return
     */
    @PostMapping
    public Stagiaire createStagiaire(@RequestBody Stagiaire stagiaire){
        Stagiaire stagiaire1 = stagiairelmp.saveStagiaire(stagiaire);
        return stagiaire1;
    }

    /**
     * endpoint: pour Listes les stagiaires ById
     * @return
     */
    @GetMapping("{id}")
    public Stagiaire getStagiaireById(@PathVariable UUID id){
        Stagiaire stagiaire = stagiairelmp.getStagiaireById(id);
        return stagiaire;
    }

    /**
     * endpoint: pour Modifier les stagiaires par Id
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable UUID id ,@RequestBody Stagiaire stagiaireDetails){
        Stagiaire updateStagiaire = stagiaireRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Stagiaire Not exist with id" + id));

        stagiaireDetails.setFirstname(stagiaireDetails.getFirstname());
        stagiaireDetails.setLastname(stagiaireDetails.getLastname());
        stagiaireDetails.setDatedeb(stagiaireDetails.getDatedeb());
        stagiaireDetails.setDatefin(stagiaireDetails.getDatefin());
        stagiaireDetails.setCin(stagiaireDetails.getCin());
        stagiaireDetails.setNumberphone(stagiaireDetails.getNumberphone());
        stagiaireDetails.setNbadge(stagiaireDetails.getNbadge());

        stagiaireRepository.save(updateStagiaire);

        return  ResponseEntity.ok(updateStagiaire);

    }

    /**
     * endpoint: pour Supprime les stagiaires
     * @return
     */

    @DeleteMapping("{id}")
    public void deleteStagiaire(@PathVariable UUID id) {stagiairelmp.deleteStagiaire(id);}

}
