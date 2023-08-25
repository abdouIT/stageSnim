package com.stagiaireapp.service.Interfaces;

import com.stagiaireapp.Model.Departement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDepartement {

    public List<Departement> getAllDepartements ();

    Departement saveDepartement(Departement departement);

    public Departement getDepartementById(Long id);
    public Departement updateDepartement(Long id, Departement departement);
    public void deleteDepartement(Long id);

}
