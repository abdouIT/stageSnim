package com.stagiaireapp.service.Classes;

import com.stagiaireapp.Model.Departement;
import com.stagiaireapp.Repository.DepartementRepository;
import com.stagiaireapp.service.Interfaces.IDepartement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class Departementlmp implements IDepartement {
    @Autowired
    private DepartementRepository departementRepository;
    @Override
    public List<Departement> getAllDepartements(){
        return departementRepository.findAll();
    }


    @Override
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
    }

    @Override
    public Departement updateDepartement(Long id, Departement departement) {
        Departement existingDepartement = departementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        existingDepartement.setNomdepartement(departement.getNomdepartement());
        existingDepartement.setNomdirection(departement.getNomdirection());

        return departementRepository.save(existingDepartement);
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

}
